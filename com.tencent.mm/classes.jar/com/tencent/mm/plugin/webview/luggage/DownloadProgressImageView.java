package com.tencent.mm.plugin.webview.luggage;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.downloader.b.a.c;
import com.tencent.mm.plugin.downloader_app.api.DownloadWidgetTaskInfo;
import com.tencent.mm.plugin.downloader_app.api.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.ao;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class DownloadProgressImageView
  extends AppCompatImageView
{
  private a.c EfU;
  private List<DownloadTaskInfo> EfV;
  private DownloadTaskInfo EfW;
  private int EfX;
  private long kzf;
  private boolean mIsDarkMode;
  private Paint mPaint;
  
  public DownloadProgressImageView(final Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(175733);
    this.kzf = -1L;
    this.EfV = new CopyOnWriteArrayList();
    this.mIsDarkMode = false;
    this.EfX = 1;
    ae.i("MicroMsg.DownloadProgressImageView", "init");
    this.mIsDarkMode = al.isDarkMode();
    this.mPaint = new Paint();
    this.mPaint.setAntiAlias(true);
    this.mPaint.setStyle(Paint.Style.STROKE);
    this.EfU = new a.c()
    {
      public final void aa(Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(175717);
        int k;
        int i;
        int j;
        if (paramAnonymousBundle.getBoolean("downloadInWidget"))
        {
          k = paramAnonymousBundle.getInt("event");
          i = paramAnonymousBundle.getInt("state");
          String str = paramAnonymousBundle.getString("appId");
          j = paramAnonymousBundle.getInt("progress");
          paramAnonymousBundle = new DownloadProgressImageView.DownloadTaskInfo();
          paramAnonymousBundle.appId = str;
          paramAnonymousBundle.state = i;
          paramAnonymousBundle.progress = j;
          if ((k != 1) && (k != 7)) {
            break label179;
          }
          if (DownloadProgressImageView.a(DownloadProgressImageView.this).contains(paramAnonymousBundle)) {
            break label133;
          }
          DownloadProgressImageView.a(DownloadProgressImageView.this).add(0, paramAnonymousBundle);
        }
        for (;;)
        {
          DownloadProgressImageView.this.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(175716);
              DownloadProgressImageView.b(DownloadProgressImageView.this);
              AppMethodBeat.o(175716);
            }
          });
          AppMethodBeat.o(175717);
          return;
          label133:
          k = DownloadProgressImageView.a(DownloadProgressImageView.this).indexOf(paramAnonymousBundle);
          paramAnonymousBundle = (DownloadProgressImageView.DownloadTaskInfo)DownloadProgressImageView.a(DownloadProgressImageView.this).get(k);
          paramAnonymousBundle.state = i;
          paramAnonymousBundle.progress = j;
          continue;
          label179:
          if ((k == 4) || (k == 9))
          {
            DownloadProgressImageView.a(DownloadProgressImageView.this).remove(paramAnonymousBundle);
          }
          else
          {
            k = DownloadProgressImageView.a(DownloadProgressImageView.this).indexOf(paramAnonymousBundle);
            if (k != -1)
            {
              paramAnonymousBundle = (DownloadProgressImageView.DownloadTaskInfo)DownloadProgressImageView.a(DownloadProgressImageView.this).get(k);
              paramAnonymousBundle.state = i;
              paramAnonymousBundle.progress = j;
            }
          }
        }
      }
    };
    paramContext = new GetDownloadWidgeInfoTask();
    paramContext.callback = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(175718);
        paramContext.bix();
        DownloadProgressImageView.a(DownloadProgressImageView.this, paramContext.Egb);
        DownloadProgressImageView.b(DownloadProgressImageView.this);
        AppMethodBeat.o(175718);
      }
    };
    paramContext.biw();
    AppBrandMainProcessService.a(paramContext);
    setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(175719);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/luggage/DownloadProgressImageView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        paramAnonymousView = new Intent();
        paramAnonymousView.putExtra("view_task", true);
        paramAnonymousView.putExtra("from_scene", 3);
        ((c)g.ab(c.class)).a(DownloadProgressImageView.this.getContext(), paramAnonymousView, null);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/luggage/DownloadProgressImageView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(175719);
      }
    });
    AppMethodBeat.o(175733);
  }
  
  private void eSJ()
  {
    AppMethodBeat.i(198003);
    int i = 0;
    switch (this.EfX)
    {
    }
    for (;;)
    {
      if (i != 0) {
        setImageResource(i);
      }
      AppMethodBeat.o(198003);
      return;
      if (this.mIsDarkMode)
      {
        i = 2131690061;
      }
      else
      {
        i = 2131690060;
        continue;
        if (this.mIsDarkMode)
        {
          i = 2131690074;
        }
        else
        {
          i = 2131690073;
          continue;
          if (this.mIsDarkMode) {
            i = 2131690068;
          } else {
            i = 2131690067;
          }
        }
      }
    }
  }
  
  private void setImageDrawableWrapper(int paramInt)
  {
    AppMethodBeat.i(198002);
    this.EfX = paramInt;
    eSJ();
    AppMethodBeat.o(198002);
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(175734);
    super.onAttachedToWindow();
    com.tencent.mm.plugin.downloader.b.a.a(this.EfU);
    AppMethodBeat.o(175734);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(175735);
    super.onDetachedFromWindow();
    com.tencent.mm.plugin.downloader.b.a.b(this.EfU);
    AppMethodBeat.o(175735);
  }
  
  public void setBgColor(int paramInt)
  {
    AppMethodBeat.i(198000);
    this.mIsDarkMode = ao.acF(paramInt);
    eSJ();
    AppMethodBeat.o(198000);
  }
  
  public void setDarkMode(boolean paramBoolean)
  {
    AppMethodBeat.i(198001);
    this.mIsDarkMode = paramBoolean;
    eSJ();
    AppMethodBeat.o(198001);
  }
  
  static class DownloadTaskInfo
    implements Parcelable
  {
    public static final Parcelable.Creator<DownloadTaskInfo> CREATOR;
    public String appId;
    public int progress;
    public int state;
    
    static
    {
      AppMethodBeat.i(175724);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(175724);
    }
    
    public DownloadTaskInfo() {}
    
    private DownloadTaskInfo(Parcel paramParcel)
    {
      AppMethodBeat.i(175721);
      this.appId = paramParcel.readString();
      this.state = paramParcel.readInt();
      this.progress = paramParcel.readInt();
      AppMethodBeat.o(175721);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public boolean equals(Object paramObject)
    {
      AppMethodBeat.i(175722);
      if ((paramObject != null) && ((paramObject instanceof DownloadTaskInfo)) && (((DownloadTaskInfo)paramObject).appId.equals(this.appId)))
      {
        AppMethodBeat.o(175722);
        return true;
      }
      AppMethodBeat.o(175722);
      return false;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(175723);
      paramParcel.writeString(this.appId);
      paramParcel.writeInt(this.state);
      paramParcel.writeInt(this.progress);
      AppMethodBeat.o(175723);
    }
  }
  
  static class GetDownloadWidgeInfoTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<GetDownloadWidgeInfoTask> CREATOR;
    public ArrayList<DownloadProgressImageView.DownloadTaskInfo> Egb;
    public Runnable callback;
    
    static
    {
      AppMethodBeat.i(175732);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(175732);
    }
    
    public GetDownloadWidgeInfoTask()
    {
      AppMethodBeat.i(175726);
      this.Egb = new ArrayList();
      AppMethodBeat.o(175726);
    }
    
    private GetDownloadWidgeInfoTask(Parcel paramParcel)
    {
      AppMethodBeat.i(175727);
      this.Egb = new ArrayList();
      e(paramParcel);
      AppMethodBeat.o(175727);
    }
    
    public final void aOX()
    {
      AppMethodBeat.i(175730);
      if (g.ab(c.class) == null)
      {
        AppMethodBeat.o(175730);
        return;
      }
      Object localObject = ((c)g.ab(c.class)).cdV();
      if (bu.ht((List)localObject))
      {
        biG();
        AppMethodBeat.o(175730);
        return;
      }
      localObject = ((LinkedList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        DownloadWidgetTaskInfo localDownloadWidgetTaskInfo = (DownloadWidgetTaskInfo)((Iterator)localObject).next();
        DownloadProgressImageView.DownloadTaskInfo localDownloadTaskInfo = new DownloadProgressImageView.DownloadTaskInfo();
        localDownloadTaskInfo.appId = localDownloadWidgetTaskInfo.appId;
        localDownloadTaskInfo.state = localDownloadWidgetTaskInfo.state;
        localDownloadTaskInfo.progress = localDownloadWidgetTaskInfo.progress;
        this.Egb.add(localDownloadTaskInfo);
      }
      biG();
      AppMethodBeat.o(175730);
    }
    
    public final void aOY()
    {
      AppMethodBeat.i(175731);
      if (this.callback != null) {
        this.callback.run();
      }
      AppMethodBeat.o(175731);
    }
    
    public final void e(Parcel paramParcel)
    {
      AppMethodBeat.i(175728);
      this.Egb = paramParcel.readArrayList(DownloadProgressImageView.DownloadTaskInfo.class.getClassLoader());
      AppMethodBeat.o(175728);
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(175729);
      paramParcel.writeList(this.Egb);
      AppMethodBeat.o(175729);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.DownloadProgressImageView
 * JD-Core Version:    0.7.0.1
 */