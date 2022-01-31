package com.tencent.ttpic.particlesystem2d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.model.StickerItem;
import com.tencent.ttpic.model.TriggerCtrlItem;
import com.tencent.ttpic.model.WMGroup;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

public class ParticleItem
{
  private static final String TAG;
  private TreeSet<Integer> activeWMGroupIndiesSet;
  public boolean canUpdateTexture;
  public int clearMode;
  public int curRepeatCount;
  public int curTexture;
  public int curWMGroupId;
  public int emissionMode;
  public float emitterX;
  public float emitterY;
  private TreeSet<Integer> idleWMGroupIndiesSet;
  public boolean lastFrameParticleReachMax;
  public long lastUpdateTimestamp;
  public List<WMGroup> lockedWMGroups;
  public int maxRepeatCount;
  public int minUpdateInterval;
  public boolean particleAlwaysUpdate;
  public boolean particleReachMax;
  public Particle[] particles;
  public float screenRatioScale;
  public StickerItem stickerItem;
  public boolean takenByParticle;
  public boolean textureUpdated;
  public TriggerCtrlItem triggerCtrlItem;
  public boolean triggered;
  public int updateCount;
  
  static
  {
    AppMethodBeat.i(83649);
    TAG = ParticleItem.class.getSimpleName();
    AppMethodBeat.o(83649);
  }
  
  public ParticleItem(StickerItem paramStickerItem)
  {
    AppMethodBeat.i(83641);
    this.screenRatioScale = 1.0F;
    this.curRepeatCount = 0;
    this.maxRepeatCount = 1;
    this.canUpdateTexture = true;
    this.updateCount = 0;
    this.takenByParticle = false;
    this.lockedWMGroups = new ArrayList();
    this.idleWMGroupIndiesSet = new TreeSet();
    this.activeWMGroupIndiesSet = new TreeSet();
    this.stickerItem = paramStickerItem;
    initIdleWMGroupIndiesSet();
    AppMethodBeat.o(83641);
  }
  
  private void initIdleWMGroupIndiesSet()
  {
    AppMethodBeat.i(83642);
    int i = 0;
    while (i < this.stickerItem.wmGroupCopies.size())
    {
      this.idleWMGroupIndiesSet.add(Integer.valueOf(i));
      i += 1;
    }
    AppMethodBeat.o(83642);
  }
  
  public List<WMGroup> getActiveWMGroups()
  {
    AppMethodBeat.i(83645);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.activeWMGroupIndiesSet.iterator();
    while (localIterator.hasNext())
    {
      int i = ((Integer)localIterator.next()).intValue();
      if (((WMGroup)this.stickerItem.wmGroupCopies.get(i)).isAsyncDrawFinished()) {
        localArrayList.add(this.stickerItem.wmGroupCopies.get(i));
      }
    }
    AppMethodBeat.o(83645);
    return localArrayList;
  }
  
  public WMGroup getAvailableWMGroup()
  {
    AppMethodBeat.i(83643);
    if (!this.idleWMGroupIndiesSet.isEmpty())
    {
      WMGroup localWMGroup = (WMGroup)this.stickerItem.wmGroupCopies.get(((Integer)this.idleWMGroupIndiesSet.pollFirst()).intValue());
      AppMethodBeat.o(83643);
      return localWMGroup;
    }
    AppMethodBeat.o(83643);
    return null;
  }
  
  public void recycleWMGroup(int paramInt)
  {
    AppMethodBeat.i(83646);
    this.idleWMGroupIndiesSet.add(Integer.valueOf(paramInt));
    this.activeWMGroupIndiesSet.remove(Integer.valueOf(paramInt));
    ((WMGroup)this.stickerItem.wmGroupCopies.get(paramInt)).reset();
    AppMethodBeat.o(83646);
  }
  
  public void reset()
  {
    AppMethodBeat.i(83647);
    this.particleReachMax = false;
    this.lastFrameParticleReachMax = false;
    this.canUpdateTexture = true;
    this.curRepeatCount = 0;
    this.curTexture = 0;
    this.triggered = false;
    if (this.particles != null)
    {
      Particle[] arrayOfParticle = this.particles;
      int j = arrayOfParticle.length;
      int i = 0;
      while (i < j)
      {
        Particle localParticle = arrayOfParticle[i];
        localParticle.alive = false;
        localParticle.texture = 0;
        i += 1;
      }
    }
    resetWMGroup();
    AppMethodBeat.o(83647);
  }
  
  public void resetWMGroup()
  {
    AppMethodBeat.i(83648);
    this.idleWMGroupIndiesSet.clear();
    this.activeWMGroupIndiesSet.clear();
    initIdleWMGroupIndiesSet();
    if (this.stickerItem.wmGroupCopies != null)
    {
      Iterator localIterator = this.stickerItem.wmGroupCopies.iterator();
      while (localIterator.hasNext())
      {
        WMGroup localWMGroup = (WMGroup)localIterator.next();
        localWMGroup.unlock();
        localWMGroup.reset();
      }
    }
    AppMethodBeat.o(83648);
  }
  
  public void useWMGroup(int paramInt)
  {
    AppMethodBeat.i(83644);
    this.idleWMGroupIndiesSet.remove(Integer.valueOf(paramInt));
    this.activeWMGroupIndiesSet.add(Integer.valueOf(paramInt));
    AppMethodBeat.o(83644);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.ttpic.particlesystem2d.ParticleItem
 * JD-Core Version:    0.7.0.1
 */