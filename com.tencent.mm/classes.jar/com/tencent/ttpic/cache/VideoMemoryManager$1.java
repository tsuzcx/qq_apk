package com.tencent.ttpic.cache;

import com.tencent.ttpic.device.DeviceInstance;
import com.tencent.ttpic.model.VideoMaterial;
import com.tencent.ttpic.util.VideoDeviceUtil;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

class VideoMemoryManager$1
  implements Runnable
{
  VideoMemoryManager$1(VideoMemoryManager paramVideoMemoryManager, VideoMaterial paramVideoMaterial) {}
  
  public void run()
  {
    long l1 = VideoDeviceUtil.getRuntimeRemainSize(1);
    long l2 = Math.min(Math.max(Math.min(l1 * 0.75D, l1 - 51200L), 0.0D), DeviceInstance.getInstance().getMaxMemorySizeInKB());
    l1 = l2;
    if (VideoMemoryManager.access$000(this.this$0) > 0) {
      l1 = Math.min(l2, VideoMemoryManager.access$000(this.this$0));
    }
    l2 = VideoMemoryManager.access$100(this.this$0, this.val$material);
    VideoMemoryManager.access$202(this.this$0, l2 / 1024L);
    VideoMemoryManager.access$302(this.this$0, VideoMaterialUtil.calSampleSize(l1, l2));
    VideoMemoryManager.access$400();
    new StringBuilder("[heap size] = ").append(l1 / 1024L).append(" MB, [material size] = ").append(VideoMemoryManager.access$200(this.this$0)).append(" MB, [sampleSize] = ").append(VideoMemoryManager.access$300(this.this$0));
    VideoMemoryManager.access$500(this.this$0, this.val$material, VideoMemoryManager.access$300(this.this$0));
    VideoMemoryManager.access$600(this.this$0, this.val$material, VideoMemoryManager.access$300(this.this$0));
    Iterator localIterator = VideoMemoryManager.access$700(this.this$0).values().iterator();
    while (localIterator.hasNext()) {
      ((LoadItemManager)localIterator.next()).prepareImages();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.ttpic.cache.VideoMemoryManager.1
 * JD-Core Version:    0.7.0.1
 */