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
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.qqmail.d.aj;
import com.tencent.mm.plugin.qqmail.d.ap;
import com.tencent.mm.pluginsdk.ui.tools.FileExplorerUI;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.i;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class b
  implements CdnLogic.UploadCallback, f
{
  private TextView xel;
  private ImageView xem;
  private ComposeUI xfD;
  private ViewGroup xfE;
  Map<String, aj> xfF;
  private Map<String, com.tencent.mm.plugin.qqmail.e.a> xfG;
  private Map<String, String> xfH;
  b xfI;
  private View.OnClickListener xfJ;
  
  private b(ComposeUI paramComposeUI, TextView paramTextView, ImageView paramImageView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(123021);
    this.xfF = new HashMap();
    this.xfG = new HashMap();
    this.xfH = new HashMap();
    this.xfI = null;
    this.xfJ = null;
    this.xfD = paramComposeUI;
    this.xfE = paramViewGroup;
    this.xfJ = null;
    this.xel = paramTextView;
    this.xem = paramImageView;
    dCL();
    g.ajB().gAO.a(11665, this);
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
    Object localObject = (LinearLayout)this.xfE.findViewById(i);
    if (localObject == null)
    {
      AppMethodBeat.o(123034);
      return;
    }
    localObject = (a)((LinearLayout)localObject).getTag();
    ad.i("MicroMsg.Mail.FileUploadHelper", "show upload status %d", new Object[] { Integer.valueOf(paramaj.state) });
    switch (paramaj.state)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(123034);
      return;
      ((a)localObject).jfJ.setTextColor(this.xfD.getResources().getColor(2131100711));
      ((a)localObject).xfR.setVisibility(0);
      ((a)localObject).xfS.setVisibility(8);
      ((a)localObject).xfT.setVisibility(8);
      ((a)localObject).xfU.setVisibility(0);
      AppMethodBeat.o(123034);
      return;
      ((a)localObject).jfJ.setTextColor(this.xfD.getResources().getColor(2131100711));
      ((a)localObject).xfR.setVisibility(8);
      ((a)localObject).xfS.setVisibility(8);
      ((a)localObject).xfT.setVisibility(8);
      ((a)localObject).xfU.setVisibility(0);
      AppMethodBeat.o(123034);
      return;
      ((a)localObject).jfJ.setTextColor(com.tencent.mm.cc.a.n(this.xfD, 2131100544));
      ((a)localObject).xfR.setVisibility(8);
      ((a)localObject).xfS.setVisibility(0);
      ((a)localObject).xfT.setVisibility(0);
      ((a)localObject).xfU.setVisibility(0);
    }
  }
  
  public final boolean JI(String paramString)
  {
    AppMethodBeat.i(123024);
    boolean bool = this.xfF.containsKey(paramString);
    AppMethodBeat.o(123024);
    return bool;
  }
  
  final void a(final aj paramaj)
  {
    AppMethodBeat.i(123025);
    final LinearLayout localLinearLayout = (LinearLayout)((ViewGroup)View.inflate(this.xfD, 2131495156, null)).findViewById(2131303313);
    ImageView localImageView1 = (ImageView)localLinearLayout.findViewById(2131303312);
    TextView localTextView1 = (TextView)localLinearLayout.findViewById(2131303314);
    TextView localTextView2 = (TextView)localLinearLayout.findViewById(2131303316);
    ProgressBar localProgressBar = (ProgressBar)localLinearLayout.findViewById(2131303317);
    TextView localTextView3 = (TextView)localLinearLayout.findViewById(2131303318);
    ImageView localImageView2 = (ImageView)localLinearLayout.findViewById(2131303315);
    ImageView localImageView3 = (ImageView)localLinearLayout.findViewById(2131303311);
    ((ViewGroup)localLinearLayout.getParent()).removeView(localLinearLayout);
    localImageView1.setImageResource(FileExplorerUI.aNp(paramaj.name));
    localTextView1.setText(paramaj.name);
    localTextView2.setText(bt.sy(paramaj.size));
    a locala = new a((byte)0);
    locala.lZa = localImageView1;
    locala.jfJ = localTextView1;
    locala.xfn = localTextView2;
    locala.xfR = localProgressBar;
    locala.xfS = localTextView3;
    locala.xfT = localImageView2;
    locala.xfU = localImageView3;
    localLinearLayout.setTag(locala);
    localLinearLayout.setId(Math.abs(paramaj.path.hashCode() / 2));
    if (this.xfJ != null) {
      localLinearLayout.setOnClickListener(this.xfJ);
    }
    this.xfE.addView(localLinearLayout);
    dCL();
    localLinearLayout.setOnClickListener(new b.1(this, localImageView2));
    localImageView2.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(123009);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/qqmail/ui/FileUploadHelper$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        paramaj.xcO = b.a(b.this, paramaj.path);
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
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/qqmail/ui/FileUploadHelper$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        h.a(b.a(b.this), 2131761951, 2131755906, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            AppMethodBeat.i(123010);
            if ((b.3.this.xfM.state == 0) || (b.3.this.xfM.state == 1)) {
              b.a(b.this, b.3.this.xfM);
            }
            b.b(b.this).remove(b.3.this.xfM.path);
            b.c(b.this).remove(b.3.this.xfM.path);
            b.d(b.this).removeView(b.3.this.xfN);
            b.this.dCL();
            AppMethodBeat.o(123010);
          }
        }, null);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/qqmail/ui/FileUploadHelper$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(123011);
      }
    });
    this.xfE.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(123012);
        b.b(b.this, paramaj);
        AppMethodBeat.o(123012);
      }
    });
    if (paramaj.state == 0) {
      paramaj.xcO = avc(paramaj.path);
    }
    AppMethodBeat.o(123025);
  }
  
  final long avc(String paramString)
  {
    AppMethodBeat.i(123029);
    try
    {
      Object localObject1 = new e(paramString);
      ad.i("MicroMsg.Mail.FileUploadHelper", "doNormalUpload %s", new Object[] { paramString, ((e)localObject1).getName() });
      Object localObject2 = i.aY(paramString, 0, (int)((e)localObject1).length());
      String str = com.tencent.mm.b.n.bytesToHex(MessageDigest.getInstance("SHA1").digest((byte[])localObject2));
      localObject2 = ai.B((byte[])localObject2);
      localObject1 = new com.tencent.mm.plugin.qqmail.e.a(paramString, (int)((e)localObject1).length(), str, (String)localObject2);
      g.aiU().a((com.tencent.mm.al.n)localObject1, 0);
      this.xfG.put(paramString, localObject1);
      long l = System.currentTimeMillis();
      AppMethodBeat.o(123029);
      return l;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.Mail.FileUploadHelper", paramString, "", new Object[0]);
      }
    }
  }
  
  public final LinkedList<aj> dCI()
  {
    AppMethodBeat.i(123027);
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = this.xfF.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localLinkedList.add(this.xfF.get(str));
    }
    AppMethodBeat.o(123027);
    return localLinkedList;
  }
  
  public final void dCJ()
  {
    AppMethodBeat.i(123028);
    Iterator localIterator = this.xfF.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (aj)this.xfF.get(localObject);
      if (((aj)localObject).state != 2)
      {
        com.tencent.mm.plugin.qqmail.e.a locala = (com.tencent.mm.plugin.qqmail.e.a)this.xfG.get(((aj)localObject).path);
        if (locala != null)
        {
          g.ajB().gAO.a(locala);
          ((aj)localObject).state = 3;
          b((aj)localObject);
          this.xfG.remove(((aj)localObject).path);
        }
      }
    }
    AppMethodBeat.o(123028);
  }
  
  public final boolean dCK()
  {
    AppMethodBeat.i(123031);
    Iterator localIterator = this.xfF.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (aj)this.xfF.get(localObject);
      if ((((aj)localObject).state != 2) && (((aj)localObject).state != 3))
      {
        AppMethodBeat.o(123031);
        return false;
      }
    }
    AppMethodBeat.o(123031);
    return true;
  }
  
  public final void dCL()
  {
    AppMethodBeat.i(123032);
    int j;
    int i;
    if (this.xfF.size() == 0)
    {
      this.xel.setText(this.xfD.getString(2131761958) + " " + this.xfD.getString(2131761961));
      this.xem.setImageResource(2131691058);
      ((View)this.xfE.getParent()).setVisibility(8);
      j = this.xfE.getChildCount();
      i = 0;
      label102:
      if (i >= j) {
        break label311;
      }
      if (j != 1) {
        break label245;
      }
      this.xfE.getChildAt(i).setBackgroundResource(2131233185);
    }
    for (;;)
    {
      i += 1;
      break label102;
      this.xel.setText(this.xfD.getString(2131761958) + this.xfD.getResources().getQuantityString(2131623962, this.xfF.size(), new Object[] { Integer.valueOf(this.xfF.size()), bt.sy(getTotalSize()) }));
      this.xem.setImageResource(2131691059);
      ((View)this.xfE.getParent()).setVisibility(0);
      break;
      label245:
      if (i == 0) {
        this.xfE.getChildAt(i).setBackgroundResource(2131233186);
      } else if ((i > 0) && (i < j - 1)) {
        this.xfE.getChildAt(i).setBackgroundResource(2131233187);
      } else {
        this.xfE.getChildAt(i).setBackgroundResource(2131233188);
      }
    }
    label311:
    AppMethodBeat.o(123032);
  }
  
  public final void eT(List<aj> paramList)
  {
    AppMethodBeat.i(215307);
    if (paramList == null)
    {
      AppMethodBeat.o(215307);
      return;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      aj localaj = (aj)paramList.next();
      this.xfF.put(localaj.path, localaj);
      a(localaj);
    }
    AppMethodBeat.o(215307);
  }
  
  public final int getTotalSize()
  {
    AppMethodBeat.i(123033);
    Iterator localIterator = this.xfF.keySet().iterator();
    String str;
    long l;
    for (int i = 0; localIterator.hasNext(); i = (int)(((aj)this.xfF.get(str)).size + l))
    {
      str = (String)localIterator.next();
      l = i;
    }
    AppMethodBeat.o(123033);
    return i;
  }
  
  public final void onC2CUploadCompleted(String paramString, final CdnLogic.C2CUploadResult paramC2CUploadResult)
  {
    AppMethodBeat.i(215308);
    ad.i("MicroMsg.Mail.FileUploadHelper", "onC2CUploadCompleted %s", new Object[] { paramString });
    if (this.xfH.containsKey(paramString)) {
      aq.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(215306);
          if (this.xfP != null)
          {
            if (paramC2CUploadResult.errorCode == 0) {
              break label47;
            }
            this.xfP.state = 3;
          }
          for (;;)
          {
            b.b(b.this, this.xfP);
            AppMethodBeat.o(215306);
            return;
            label47:
            this.xfP.state = 2;
            b.e(b.this);
          }
        }
      });
    }
    AppMethodBeat.o(215308);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(123035);
    if (paramn.getType() == 11665)
    {
      String str = ((com.tencent.mm.plugin.qqmail.e.a)paramn).filePath;
      ad.i("MicroMsg.Mail.FileUploadHelper", "errType %d, errCode %d, errMsg %s, filePath %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, str });
      paramString = (aj)this.xfF.get(str);
      this.xfG.remove(str);
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
        localC2CUploadRequest.fileKey = ((com.tencent.mm.plugin.qqmail.e.a)paramn).xdC;
        localC2CUploadRequest.setFilePath(str);
        localC2CUploadRequest.forwardFileid = ((ap)((com.tencent.mm.plugin.qqmail.e.a)paramn).hWL.hNL.hNQ).xdk;
        localC2CUploadRequest.host = ((ap)((com.tencent.mm.plugin.qqmail.e.a)paramn).hWL.hNL.hNQ).xdj;
        this.xfH.put(localC2CUploadRequest.fileKey, str);
        paramString.state = 1;
        paramString.uDM = ((ap)((com.tencent.mm.plugin.qqmail.e.a)paramn).hWL.hNL.hNQ).fileid;
        b(paramString);
        CdnLogic.startFtnUpload(localC2CUploadRequest, this);
      }
    }
    AppMethodBeat.o(123035);
  }
  
  public final void onUploadProgressChanged(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(221590);
    ad.i("MicroMsg.Mail.FileUploadHelper", "onUploadProgressChanged fileKey:%s finish:%d total:%d", new Object[] { paramString, Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    AppMethodBeat.o(221590);
  }
  
  final class a
  {
    TextView jfJ;
    ImageView lZa;
    ProgressBar xfR;
    TextView xfS;
    ImageView xfT;
    ImageView xfU;
    TextView xfn;
    
    private a() {}
  }
  
  public static abstract interface b
  {
    public abstract void dCB();
    
    public abstract void onComplete();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.b
 * JD-Core Version:    0.7.0.1
 */