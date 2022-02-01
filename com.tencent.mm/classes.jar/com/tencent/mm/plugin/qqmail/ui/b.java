package com.tencent.mm.plugin.qqmail.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mars.cdn.CdnLogic.C2CUploadRequest;
import com.tencent.mars.cdn.CdnLogic.C2CUploadResult;
import com.tencent.mars.cdn.CdnLogic.UploadCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.b.n;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.qqmail.d.aj;
import com.tencent.mm.plugin.qqmail.d.ap;
import com.tencent.mm.pluginsdk.ui.tools.FileExplorerUI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class b
  implements CdnLogic.UploadCallback, i
{
  private TextView Buf;
  private ImageView Bug;
  private Map<String, com.tencent.mm.plugin.qqmail.e.a> BvA;
  private Map<String, String> BvB;
  b BvC;
  private View.OnClickListener BvD;
  private ComposeUI Bvy;
  Map<String, aj> Bvz;
  private ViewGroup ulG;
  
  private b(ComposeUI paramComposeUI, TextView paramTextView, ImageView paramImageView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(123021);
    this.Bvz = new HashMap();
    this.BvA = new HashMap();
    this.BvB = new HashMap();
    this.BvC = null;
    this.BvD = null;
    this.Bvy = paramComposeUI;
    this.ulG = paramViewGroup;
    this.BvD = null;
    this.Buf = paramTextView;
    this.Bug = paramImageView;
    eGQ();
    g.aAg().hqi.a(11665, this);
    AppMethodBeat.o(123021);
  }
  
  public b(ComposeUI paramComposeUI, TextView paramTextView, ImageView paramImageView, ViewGroup paramViewGroup, byte paramByte)
  {
    this(paramComposeUI, paramTextView, paramImageView, paramViewGroup);
  }
  
  private void b(aj paramaj)
  {
    AppMethodBeat.i(123034);
    int i = Math.abs(paramaj.path.hashCode() / 2);
    Object localObject = (LinearLayout)this.ulG.findViewById(i);
    if (localObject == null)
    {
      AppMethodBeat.o(123034);
      return;
    }
    localObject = (a)((LinearLayout)localObject).getTag();
    Log.i("MicroMsg.Mail.FileUploadHelper", "show upload status %d", new Object[] { Integer.valueOf(paramaj.state) });
    switch (paramaj.state)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(123034);
      return;
      ((a)localObject).kgE.setTextColor(this.Bvy.getResources().getColor(2131100904));
      ((a)localObject).uploadingPB.setVisibility(0);
      ((a)localObject).BvL.setVisibility(8);
      ((a)localObject).BvM.setVisibility(8);
      ((a)localObject).BvN.setVisibility(0);
      AppMethodBeat.o(123034);
      return;
      ((a)localObject).kgE.setTextColor(this.Bvy.getResources().getColor(2131100904));
      ((a)localObject).uploadingPB.setVisibility(8);
      ((a)localObject).BvL.setVisibility(8);
      ((a)localObject).BvM.setVisibility(8);
      ((a)localObject).BvN.setVisibility(0);
      AppMethodBeat.o(123034);
      return;
      ((a)localObject).kgE.setTextColor(com.tencent.mm.cb.a.n(this.Bvy, 2131100682));
      ((a)localObject).uploadingPB.setVisibility(8);
      ((a)localObject).BvL.setVisibility(0);
      ((a)localObject).BvM.setVisibility(0);
      ((a)localObject).BvN.setVisibility(0);
    }
  }
  
  public final boolean Tf(String paramString)
  {
    AppMethodBeat.i(123024);
    boolean bool = this.Bvz.containsKey(paramString);
    AppMethodBeat.o(123024);
    return bool;
  }
  
  final void a(final aj paramaj)
  {
    AppMethodBeat.i(123025);
    final LinearLayout localLinearLayout = (LinearLayout)((ViewGroup)View.inflate(this.Bvy, 2131495999, null)).findViewById(2131305987);
    ImageView localImageView1 = (ImageView)localLinearLayout.findViewById(2131305986);
    TextView localTextView1 = (TextView)localLinearLayout.findViewById(2131305988);
    TextView localTextView2 = (TextView)localLinearLayout.findViewById(2131305990);
    ProgressBar localProgressBar = (ProgressBar)localLinearLayout.findViewById(2131305991);
    TextView localTextView3 = (TextView)localLinearLayout.findViewById(2131305992);
    final ImageView localImageView2 = (ImageView)localLinearLayout.findViewById(2131305989);
    ImageView localImageView3 = (ImageView)localLinearLayout.findViewById(2131305985);
    ((ViewGroup)localLinearLayout.getParent()).removeView(localLinearLayout);
    localImageView1.setImageResource(FileExplorerUI.bfq(paramaj.name));
    localTextView1.setText(paramaj.name);
    localTextView2.setText(Util.getSizeKB(paramaj.size));
    a locala = new a((byte)0);
    locala.nnL = localImageView1;
    locala.kgE = localTextView1;
    locala.Bvi = localTextView2;
    locala.uploadingPB = localProgressBar;
    locala.BvL = localTextView3;
    locala.BvM = localImageView2;
    locala.BvN = localImageView3;
    localLinearLayout.setTag(locala);
    localLinearLayout.setId(Math.abs(paramaj.path.hashCode() / 2));
    if (this.BvD != null) {
      localLinearLayout.setOnClickListener(this.BvD);
    }
    this.ulG.addView(localLinearLayout);
    eGQ();
    localLinearLayout.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(123008);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/qqmail/ui/FileUploadHelper$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if (localImageView2.getVisibility() == 0) {
          localImageView2.performClick();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/qqmail/ui/FileUploadHelper$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(123008);
      }
    });
    localImageView2.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(123009);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/qqmail/ui/FileUploadHelper$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        paramaj.ulj = b.a(b.this, paramaj.path);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/qqmail/ui/FileUploadHelper$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(123009);
      }
    });
    localImageView3.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(123011);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/qqmail/ui/FileUploadHelper$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        h.a(b.a(b.this), 2131763957, 2131755998, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            AppMethodBeat.i(123010);
            if ((b.3.this.BvG.state == 0) || (b.3.this.BvG.state == 1)) {
              b.a(b.this, b.3.this.BvG);
            }
            b.b(b.this).remove(b.3.this.BvG.path);
            b.c(b.this).remove(b.3.this.BvG.path);
            b.d(b.this).removeView(b.3.this.BvH);
            b.this.eGQ();
            AppMethodBeat.o(123010);
          }
        }, null);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/qqmail/ui/FileUploadHelper$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(123011);
      }
    });
    this.ulG.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(123012);
        b.b(b.this, paramaj);
        AppMethodBeat.o(123012);
      }
    });
    if (paramaj.state == 0) {
      paramaj.ulj = aKJ(paramaj.path);
    }
    AppMethodBeat.o(123025);
  }
  
  final long aKJ(String paramString)
  {
    AppMethodBeat.i(123029);
    try
    {
      Object localObject1 = new o(paramString);
      Log.i("MicroMsg.Mail.FileUploadHelper", "doNormalUpload %s", new Object[] { paramString, ((o)localObject1).getName() });
      Object localObject2 = s.aW(paramString, 0, (int)((o)localObject1).length());
      String str = n.bytesToHex(MessageDigest.getInstance("SHA1").digest((byte[])localObject2));
      localObject2 = MD5Util.getMD5String((byte[])localObject2);
      localObject1 = new com.tencent.mm.plugin.qqmail.e.a(paramString, (int)((o)localObject1).length(), str, (String)localObject2);
      g.azz().a((q)localObject1, 0);
      this.BvA.put(paramString, localObject1);
      long l = System.currentTimeMillis();
      AppMethodBeat.o(123029);
      return l;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.Mail.FileUploadHelper", paramString, "", new Object[0]);
      }
    }
  }
  
  public final LinkedList<aj> eGN()
  {
    AppMethodBeat.i(123027);
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = this.Bvz.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localLinkedList.add(this.Bvz.get(str));
    }
    AppMethodBeat.o(123027);
    return localLinkedList;
  }
  
  public final void eGO()
  {
    AppMethodBeat.i(123028);
    Iterator localIterator = this.Bvz.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (aj)this.Bvz.get(localObject);
      if (((aj)localObject).state != 2)
      {
        com.tencent.mm.plugin.qqmail.e.a locala = (com.tencent.mm.plugin.qqmail.e.a)this.BvA.get(((aj)localObject).path);
        if (locala != null)
        {
          g.aAg().hqi.a(locala);
          ((aj)localObject).state = 3;
          b((aj)localObject);
          this.BvA.remove(((aj)localObject).path);
        }
      }
    }
    AppMethodBeat.o(123028);
  }
  
  public final boolean eGP()
  {
    AppMethodBeat.i(123031);
    Iterator localIterator = this.Bvz.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (aj)this.Bvz.get(localObject);
      if ((((aj)localObject).state != 2) && (((aj)localObject).state != 3))
      {
        AppMethodBeat.o(123031);
        return false;
      }
    }
    AppMethodBeat.o(123031);
    return true;
  }
  
  public final void eGQ()
  {
    AppMethodBeat.i(123032);
    int j;
    int i;
    if (this.Bvz.size() == 0)
    {
      this.Buf.setText(this.Bvy.getString(2131763964) + " " + this.Bvy.getString(2131763967));
      this.Bug.setImageResource(2131691360);
      ((View)this.ulG.getParent()).setVisibility(8);
      j = this.ulG.getChildCount();
      i = 0;
      label102:
      if (i >= j) {
        break label311;
      }
      if (j != 1) {
        break label245;
      }
      this.ulG.getChildAt(i).setBackgroundResource(2131233843);
    }
    for (;;)
    {
      i += 1;
      break label102;
      this.Buf.setText(this.Bvy.getString(2131763964) + this.Bvy.getResources().getQuantityString(2131623962, this.Bvz.size(), new Object[] { Integer.valueOf(this.Bvz.size()), Util.getSizeKB(getTotalSize()) }));
      this.Bug.setImageResource(2131691361);
      ((View)this.ulG.getParent()).setVisibility(0);
      break;
      label245:
      if (i == 0) {
        this.ulG.getChildAt(i).setBackgroundResource(2131233844);
      } else if ((i > 0) && (i < j - 1)) {
        this.ulG.getChildAt(i).setBackgroundResource(2131233845);
      } else {
        this.ulG.getChildAt(i).setBackgroundResource(2131233846);
      }
    }
    label311:
    AppMethodBeat.o(123032);
  }
  
  public final void fX(List<aj> paramList)
  {
    AppMethodBeat.i(198709);
    if (paramList == null)
    {
      AppMethodBeat.o(198709);
      return;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      aj localaj = (aj)paramList.next();
      this.Bvz.put(localaj.path, localaj);
      a(localaj);
    }
    AppMethodBeat.o(198709);
  }
  
  public final int getTotalSize()
  {
    AppMethodBeat.i(123033);
    Iterator localIterator = this.Bvz.keySet().iterator();
    String str;
    long l;
    for (int i = 0; localIterator.hasNext(); i = (int)(((aj)this.Bvz.get(str)).size + l))
    {
      str = (String)localIterator.next();
      l = i;
    }
    AppMethodBeat.o(123033);
    return i;
  }
  
  public final void onC2CUploadCompleted(String paramString, final CdnLogic.C2CUploadResult paramC2CUploadResult)
  {
    AppMethodBeat.i(198711);
    Log.i("MicroMsg.Mail.FileUploadHelper", "onC2CUploadCompleted %s", new Object[] { paramString });
    if (this.BvB.containsKey(paramString)) {
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(198708);
          if (this.BvJ != null)
          {
            if (paramC2CUploadResult.errorCode == 0) {
              break label47;
            }
            this.BvJ.state = 3;
          }
          for (;;)
          {
            b.b(b.this, this.BvJ);
            AppMethodBeat.o(198708);
            return;
            label47:
            this.BvJ.state = 2;
            b.e(b.this);
          }
        }
      });
    }
    AppMethodBeat.o(198711);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(123035);
    if (paramq.getType() == 11665)
    {
      String str = ((com.tencent.mm.plugin.qqmail.e.a)paramq).filePath;
      Log.i("MicroMsg.Mail.FileUploadHelper", "errType %d, errCode %d, errMsg %s, filePath %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, str });
      paramString = (aj)this.Bvz.get(str);
      this.BvA.remove(str);
      if (paramString != null)
      {
        if ((paramInt1 != 0) || (paramInt2 != 0))
        {
          paramString.state = 3;
          b(paramString);
          AppMethodBeat.o(123035);
          return;
        }
        CdnLogic.C2CUploadRequest localC2CUploadRequest = new CdnLogic.C2CUploadRequest();
        localC2CUploadRequest.fileKey = ((com.tencent.mm.plugin.qqmail.e.a)paramq).Btw;
        localC2CUploadRequest.setFilePath(str);
        localC2CUploadRequest.forwardFileid = ((ap)((com.tencent.mm.plugin.qqmail.e.a)paramq).iUB.iLL.iLR).Bte;
        localC2CUploadRequest.host = ((ap)((com.tencent.mm.plugin.qqmail.e.a)paramq).iUB.iLL.iLR).Btd;
        this.BvB.put(localC2CUploadRequest.fileKey, str);
        paramString.state = 1;
        paramString.svrId = ((ap)((com.tencent.mm.plugin.qqmail.e.a)paramq).iUB.iLL.iLR).fileid;
        b(paramString);
        CdnLogic.startFtnUpload(localC2CUploadRequest, this);
      }
    }
    AppMethodBeat.o(123035);
  }
  
  public final void onUploadProgressChanged(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(198710);
    Log.i("MicroMsg.Mail.FileUploadHelper", "onUploadProgressChanged fileKey:%s finish:%d total:%d", new Object[] { paramString, Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    AppMethodBeat.o(198710);
  }
  
  final class a
  {
    TextView BvL;
    ImageView BvM;
    ImageView BvN;
    TextView Bvi;
    TextView kgE;
    ImageView nnL;
    ProgressBar uploadingPB;
    
    private a() {}
  }
  
  public static abstract interface b
  {
    public abstract void eGG();
    
    public abstract void onComplete();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.b
 * JD-Core Version:    0.7.0.1
 */