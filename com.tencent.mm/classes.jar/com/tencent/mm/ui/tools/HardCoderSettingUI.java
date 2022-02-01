package com.tencent.mm.ui.tools;

import android.app.Activity;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.pluginsdk.i.i;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import java.sql.Time;
import java.text.DateFormat;

public class HardCoderSettingUI
  extends MMActivity
{
  private CheckBox KFA;
  private TextView KFB;
  private TextView KFC;
  private CheckBox KFD;
  private EditText KFE;
  private EditText KFF;
  private EditText KFG;
  private Spinner KFH;
  private Spinner KFI;
  private CheckBox KFJ;
  private CheckBox KFK;
  private EditText KFL;
  private EditText KFM;
  private EditText KFN;
  private Spinner KFO;
  private Spinner KFP;
  private CheckBox KFQ;
  private CheckBox KFR;
  private EditText KFS;
  private EditText KFT;
  private EditText KFU;
  private Spinner KFV;
  private Spinner KFW;
  private CheckBox KFX;
  private CheckBox KFY;
  private EditText KFZ;
  private CheckBox KFw;
  private EditText KFx;
  private CheckBox KFy;
  private CheckBox KFz;
  private EditText KGA;
  private CheckBox KGB;
  private EditText KGC;
  private EditText KGD;
  private EditText KGE;
  private EditText KGF;
  private EditText KGG;
  private EditText KGH;
  private Spinner KGI;
  private Spinner KGJ;
  private CheckBox KGK;
  private CheckBox KGL;
  private EditText KGM;
  private EditText KGN;
  private EditText KGO;
  private Spinner KGP;
  private Spinner KGQ;
  private CheckBox KGR;
  private CheckBox KGS;
  private EditText KGT;
  private EditText KGU;
  private EditText KGV;
  private Spinner KGW;
  private Spinner KGX;
  private CheckBox KGY;
  private CheckBox KGZ;
  private EditText KGa;
  private EditText KGb;
  private Spinner KGc;
  private Spinner KGd;
  private CheckBox KGe;
  private CheckBox KGf;
  private EditText KGg;
  private EditText KGh;
  private EditText KGi;
  private Spinner KGj;
  private Spinner KGk;
  private CheckBox KGl;
  private CheckBox KGm;
  private EditText KGn;
  private EditText KGo;
  private EditText KGp;
  private Spinner KGq;
  private Spinner KGr;
  private CheckBox KGs;
  private CheckBox KGt;
  private EditText KGu;
  private EditText KGv;
  private EditText KGw;
  private Spinner KGx;
  private Spinner KGy;
  private CheckBox KGz;
  private CheckBox KHA;
  private CheckBox KHB;
  private EditText KHC;
  private EditText KHD;
  private EditText KHE;
  private Spinner KHF;
  private Spinner KHG;
  private CheckBox KHH;
  private CheckBox KHI;
  private EditText KHJ;
  private EditText KHK;
  private EditText KHL;
  private Spinner KHM;
  private Spinner KHN;
  private CheckBox KHO;
  private CheckBox KHP;
  private EditText KHQ;
  private EditText KHR;
  private EditText KHS;
  private Spinner KHT;
  private Spinner KHU;
  private CheckBox KHV;
  private CheckBox KHW;
  private EditText KHX;
  private EditText KHY;
  private EditText KHZ;
  private EditText KHa;
  private EditText KHb;
  private EditText KHc;
  private Spinner KHd;
  private Spinner KHe;
  private CheckBox KHf;
  private CheckBox KHg;
  private EditText KHh;
  private EditText KHi;
  private EditText KHj;
  private Spinner KHk;
  private Spinner KHl;
  private CheckBox KHm;
  private CheckBox KHn;
  private EditText KHo;
  private EditText KHp;
  private EditText KHq;
  private Spinner KHr;
  private Spinner KHs;
  private CheckBox KHt;
  private CheckBox KHu;
  private EditText KHv;
  private EditText KHw;
  private EditText KHx;
  private Spinner KHy;
  private Spinner KHz;
  private Spinner KIa;
  private Spinner KIb;
  private CheckBox KIc;
  private boolean yGi;
  private final TimePickerDialog.OnTimeSetListener yGj;
  
  public HardCoderSettingUI()
  {
    AppMethodBeat.i(39064);
    this.yGi = false;
    this.yGj = new TimePickerDialog.OnTimeSetListener()
    {
      public final void onTimeSet(TimePicker paramAnonymousTimePicker, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(39063);
        if (HardCoderSettingUI.s(HardCoderSettingUI.this))
        {
          WXHardCoderJNI.hcBeginTimeHour = paramAnonymousInt1;
          WXHardCoderJNI.hcBeginTimeMin = paramAnonymousInt2;
          HardCoderSettingUI.t(HardCoderSettingUI.this).setText(HardCoderSettingUI.m(HardCoderSettingUI.this, WXHardCoderJNI.hcBeginTimeHour, WXHardCoderJNI.hcBeginTimeMin));
          AppMethodBeat.o(39063);
          return;
        }
        WXHardCoderJNI.hcEndTimeHour = paramAnonymousInt1;
        WXHardCoderJNI.hcEndTimeMin = paramAnonymousInt2;
        HardCoderSettingUI.u(HardCoderSettingUI.this).setText(HardCoderSettingUI.m(HardCoderSettingUI.this, WXHardCoderJNI.hcEndTimeHour, WXHardCoderJNI.hcEndTimeMin));
        AppMethodBeat.o(39063);
      }
    };
    AppMethodBeat.o(39064);
  }
  
  private static void b(SharedPreferences.Editor paramEditor)
  {
    AppMethodBeat.i(39068);
    paramEditor.putBoolean("KEY_HC_ENABLE", WXHardCoderJNI.getEnable());
    paramEditor.putBoolean("KEY_HC_DEBUG", WXHardCoderJNI.getDebug());
    paramEditor.putInt("KEY_HC_RETRY_INTERVAL", WXHardCoderJNI.hcRetryInterval);
    paramEditor.putBoolean("KEY_HC_TIME_LIMIT", WXHardCoderJNI.hcTimeLimit);
    paramEditor.putInt("KEY_HC_BEGIN_TIME_HOUR", WXHardCoderJNI.hcBeginTimeHour);
    paramEditor.putInt("KEY_HC_BEGIN_TIME_MIN", WXHardCoderJNI.hcBeginTimeMin);
    paramEditor.putInt("KEY_HC_END_TIME_HOUR", WXHardCoderJNI.hcEndTimeHour);
    paramEditor.putInt("KEY_HC_END_TIME_MIN", WXHardCoderJNI.hcEndTimeMin);
    paramEditor.putBoolean("KEY_HC_BOOT_ENABLE", WXHardCoderJNI.hcBootEnable);
    paramEditor.putInt("KEY_HC_BOOT_DELEY", WXHardCoderJNI.hcBootDelay);
    paramEditor.putInt("KEY_HC_BOOT_CPU", WXHardCoderJNI.hcBootCPU);
    paramEditor.putInt("KEY_HC_BOOT_IO", WXHardCoderJNI.hcBootIO);
    paramEditor.putBoolean("KEY_HC_BOOT_THR", WXHardCoderJNI.hcBootThr);
    paramEditor.putInt("KEY_HC_BOOT_TIMEOUT", WXHardCoderJNI.hcBootTimeout);
    paramEditor.putLong("KEY_HC_BOOT_ACTION", WXHardCoderJNI.hcBootAction);
    paramEditor.putBoolean("KEY_HC_ENTER_CHATTING_ENABLE", WXHardCoderJNI.hcEnterChattingEnable);
    paramEditor.putInt("KEY_HC_ENTER_CHATTING_DELEY", WXHardCoderJNI.hcEnterChattingDelay);
    paramEditor.putInt("KEY_HC_ENTER_CHATTING_CPU", WXHardCoderJNI.hcEnterChattingCPU);
    paramEditor.putInt("KEY_HC_ENTER_CHATTING_IO", WXHardCoderJNI.hcEnterChattingIO);
    paramEditor.putBoolean("KEY_HC_ENTER_CHATTING_THR", WXHardCoderJNI.hcEnterChattingThr);
    paramEditor.putInt("KEY_HC_ENTER_CHATTING_TIMEOUT", WXHardCoderJNI.hcEnterChattingTimeout);
    paramEditor.putLong("KEY_HC_ENTER_CHATTING_ACTION", WXHardCoderJNI.hcEnterChattingAction);
    paramEditor.putBoolean("KEY_HC_QUIT_CHATTING_ENABLE", WXHardCoderJNI.hcQuitChattingEnable);
    paramEditor.putInt("KEY_HC_QUIT_CHATTING_DELEY", WXHardCoderJNI.hcQuitChattingDelay);
    paramEditor.putInt("KEY_HC_QUIT_CHATTING_CPU", WXHardCoderJNI.hcQuitChattingCPU);
    paramEditor.putInt("KEY_HC_QUIT_CHATTING_IO", WXHardCoderJNI.hcQuitChattingIO);
    paramEditor.putBoolean("KEY_HC_QUIT_CHATTING_THR", WXHardCoderJNI.hcQuitChattingThr);
    paramEditor.putInt("KEY_HC_QUIT_CHATTING_TIMEOUT", WXHardCoderJNI.hcQuitChattingTimeout);
    paramEditor.putLong("KEY_HC_QUIT_CHATTING_ACTION", WXHardCoderJNI.hcQuitChattingAction);
    paramEditor.putBoolean("KEY_HC_SEND_MSG_ENABLE", WXHardCoderJNI.hcSendMsgEnable);
    paramEditor.putInt("KEY_HC_SEND_MSG_DELEY", WXHardCoderJNI.hcSendMsgDelay);
    paramEditor.putInt("KEY_HC_SEND_MSG_CPU", WXHardCoderJNI.hcSendMsgCPU);
    paramEditor.putInt("KEY_HC_SEND_MSG_IO", WXHardCoderJNI.hcSendMsgIO);
    paramEditor.putBoolean("KEY_HC_SEND_MSG_THR", WXHardCoderJNI.hcSendMsgThr);
    paramEditor.putInt("KEY_HC_SEND_MSG_TIMEOUT", WXHardCoderJNI.hcSendMsgTimeout);
    paramEditor.putLong("KEY_HC_SEND_MSG_ACTION", WXHardCoderJNI.hcSendMsgAction);
    paramEditor.putBoolean("KEY_HC_SEND_PIC_MSG_ENABLE", WXHardCoderJNI.hcSendPicMsgEnable);
    paramEditor.putInt("KEY_HC_SEND_PIC_MSG_DELEY", WXHardCoderJNI.hcSendPicMsgDelay);
    paramEditor.putInt("KEY_HC_SEND_PIC_MSG_CPU", WXHardCoderJNI.hcSendPicMsgCPU);
    paramEditor.putInt("KEY_HC_SEND_PIC_MSG_IO", WXHardCoderJNI.hcSendPicMsgIO);
    paramEditor.putBoolean("KEY_HC_SEND_PIC_MSG_THR", WXHardCoderJNI.hcSendPicMsgThr);
    paramEditor.putInt("KEY_HC_SEND_PIC_MSG_TIMEOUT", WXHardCoderJNI.hcSendPicMsgTimeout);
    paramEditor.putLong("KEY_HC_SEND_PIC_MSG_ACTION", WXHardCoderJNI.hcSendPicMsgAction);
    paramEditor.putBoolean("KEY_HC_RECEIVE_MSG_ENABLE", WXHardCoderJNI.hcReceiveMsgEnable);
    paramEditor.putInt("KEY_HC_RECEIVE_MSG_DELEY", WXHardCoderJNI.hcReceiveMsgDelay);
    paramEditor.putInt("KEY_HC_RECEIVE_MSG_CPU", WXHardCoderJNI.hcReceiveMsgCPU);
    paramEditor.putInt("KEY_HC_RECEIVE_MSG_IO", WXHardCoderJNI.hcReceiveMsgIO);
    paramEditor.putBoolean("KEY_HC_RECEIVE_MSG_THR", WXHardCoderJNI.hcReceiveMsgThr);
    paramEditor.putInt("KEY_HC_RECEIVE_MSG_TIMEOUT", WXHardCoderJNI.hcReceiveMsgTimeout);
    paramEditor.putLong("KEY_HC_RECEIVE_MSG_ACTION", WXHardCoderJNI.hcReceiveMsgAction);
    paramEditor.putBoolean("KEY_HC_UPDATE_CHATROOM_ENABLE", WXHardCoderJNI.hcUpdateChatroomEnable);
    paramEditor.putInt("KEY_HC_UPDATE_CHATROOM_DELEY", WXHardCoderJNI.hcUpdateChatroomDelay);
    paramEditor.putInt("KEY_HC_UPDATE_CHATROOM_CPU", WXHardCoderJNI.hcUpdateChatroomCPU);
    paramEditor.putInt("KEY_HC_UPDATE_CHATROOM_IO", WXHardCoderJNI.hcUpdateChatroomIO);
    paramEditor.putBoolean("KEY_HC_UPDATE_CHATROOM_THR", WXHardCoderJNI.hcUpdateChatroomThr);
    paramEditor.putInt("KEY_HC_UPDATE_CHATROOM_TIMEOUT", WXHardCoderJNI.hcUpdateChatroomTimeout);
    paramEditor.putLong("KEY_HC_UPDATE_CHATROOM_ACTION", WXHardCoderJNI.hcUpdateChatroomAction);
    paramEditor.putLong("KEY_HC_UPDATE_CHATROOM_MEMBER_COUNT", WXHardCoderJNI.hcUpdateChatroomMemberCount);
    paramEditor.putBoolean("KEY_HC_DB_ENABLE", WXHardCoderJNI.hcDBEnable);
    paramEditor.putInt("KEY_HC_DB_DELEY_QUERY", WXHardCoderJNI.hcDBDelayQuery);
    paramEditor.putInt("KEY_HC_DB_DELEY_WRITE", WXHardCoderJNI.hcDBDelayWrite);
    paramEditor.putInt("KEY_HC_DB_CPU", WXHardCoderJNI.hcDBCPU);
    paramEditor.putInt("KEY_HC_DB_IO", WXHardCoderJNI.hcDBIO);
    paramEditor.putBoolean("KEY_HC_DB_THR", WXHardCoderJNI.hcDBThr);
    paramEditor.putInt("KEY_HC_DB_TIMEOUT", WXHardCoderJNI.hcDBTimeout);
    paramEditor.putInt("KEY_HC_DB_TIMEOUT", WXHardCoderJNI.hcDBTimeoutBusy);
    paramEditor.putLong("KEY_HC_DB_ACTION_QUERY", WXHardCoderJNI.hcDBActionQuery);
    paramEditor.putLong("KEY_HC_DB_ACTION_WRITE", WXHardCoderJNI.hcDBActionWrite);
    paramEditor.putBoolean("KEY_HC_ENCODE_VIDEO_ENABLE", WXHardCoderJNI.hcEncodeVideoEnable);
    paramEditor.putInt("KEY_HC_ENCODE_VIDEO_DELEY", WXHardCoderJNI.hcEncodeVideoDelay);
    paramEditor.putInt("KEY_HC_ENCODE_VIDEO_CPU", WXHardCoderJNI.hcEncodeVideoCPU);
    paramEditor.putInt("KEY_HC_ENCODE_VIDEO_IO", WXHardCoderJNI.hcEncodeVideoIO);
    paramEditor.putBoolean("KEY_HC_ENCODE_VIDEO_THR", WXHardCoderJNI.hcEncodeVideoThr);
    paramEditor.putInt("KEY_HC_ENCODE_VIDEO_TIMEOUT", WXHardCoderJNI.hcEncodeVideoTimeout);
    paramEditor.putLong("KEY_HC_ENCODE_VIDEO_ACTION", WXHardCoderJNI.hcEncodeVideoAction);
    paramEditor.putBoolean("KEY_HC_DECODE_PIC_ENABLE", WXHardCoderJNI.hcDecodePicEnable);
    paramEditor.putInt("KEY_HC_DECODE_PIC_DELEY", WXHardCoderJNI.hcDecodePicDelay);
    paramEditor.putInt("KEY_HC_DECODE_PIC_CPU", WXHardCoderJNI.hcDecodePicCPU);
    paramEditor.putInt("KEY_HC_DECODE_PIC_IO", WXHardCoderJNI.hcDecodePicIO);
    paramEditor.putBoolean("KEY_HC_DECODE_PIC_THR", WXHardCoderJNI.hcDecodePicThr);
    paramEditor.putInt("KEY_HC_DECODE_PIC_TIMEOUT", WXHardCoderJNI.hcDecodePicTimeout);
    paramEditor.putLong("KEY_HC_DECODE_PIC_ACTION", WXHardCoderJNI.hcDecodePicAction);
    paramEditor.putBoolean("KEY_HC_GIF_ENABLE", WXHardCoderJNI.hcGifEnable);
    paramEditor.putInt("KEY_HC_GIF_DELEY", WXHardCoderJNI.hcGifDelay);
    paramEditor.putInt("KEY_HC_GIF_CPU", WXHardCoderJNI.hcGifCPU);
    paramEditor.putInt("KEY_HC_GIF_IO", WXHardCoderJNI.hcGifIO);
    paramEditor.putBoolean("KEY_HC_GIF_THR", WXHardCoderJNI.hcGifThr);
    paramEditor.putInt("KEY_HC_GIF_TIMEOUT", WXHardCoderJNI.hcGifTimeout);
    paramEditor.putLong("KEY_HC_GIF_ACTION", WXHardCoderJNI.hcGifAction);
    paramEditor.putBoolean("KEY_HC_GIF_FRAME_ENABLE", WXHardCoderJNI.hcGifFrameEnable);
    paramEditor.putInt("KEY_HC_GIF_FRAME_DELEY", WXHardCoderJNI.hcGifFrameDelay);
    paramEditor.putInt("KEY_HC_GIF_FRAME_CPU", WXHardCoderJNI.hcGifFrameCPU);
    paramEditor.putInt("KEY_HC_GIF_FRAME_IO", WXHardCoderJNI.hcGifFrameIO);
    paramEditor.putBoolean("KEY_HC_GIF_FRAME_THR", WXHardCoderJNI.hcGifFrameThr);
    paramEditor.putInt("KEY_HC_GIF_FRAME_TIMEOUT", WXHardCoderJNI.hcGifFrameTimeout);
    paramEditor.putLong("KEY_HC_GIF_FRAME_ACTION", WXHardCoderJNI.hcGifFrameAction);
    paramEditor.putBoolean("KEY_HC_SNS_SCROLL_ENABLE", WXHardCoderJNI.hcSNSScrollEnable);
    paramEditor.putInt("KEY_HC_SNS_SCROLL_DELEY", WXHardCoderJNI.hcSNSScrollDelay);
    paramEditor.putInt("KEY_HC_SNS_SCROLL_CPU", WXHardCoderJNI.hcSNSScrollCPU);
    paramEditor.putInt("KEY_HC_SNS_SCROLL_IO", WXHardCoderJNI.hcSNSScrollIO);
    paramEditor.putBoolean("KEY_HC_SNS_SCROLL_THR", WXHardCoderJNI.hcSNSScrollThr);
    paramEditor.putInt("KEY_HC_SNS_SCROLL_TIMEOUT", WXHardCoderJNI.hcSNSScrollTimeout);
    paramEditor.putLong("KEY_HC_SNS_SCROLL_ACTION", WXHardCoderJNI.hcSNSScrollAction);
    paramEditor.putBoolean("KEY_HC_SNS_USER_SCROLL_ENABLE", WXHardCoderJNI.hcSNSUserScrollEnable);
    paramEditor.putInt("KEY_HC_SNS_USER_SCROLL_DELEY", WXHardCoderJNI.hcSNSUserScrollDelay);
    paramEditor.putInt("KEY_HC_SNS_USER_SCROLL_CPU", WXHardCoderJNI.hcSNSUserScrollCPU);
    paramEditor.putInt("KEY_HC_SNS_USER_SCROLL_IO", WXHardCoderJNI.hcSNSUserScrollIO);
    paramEditor.putBoolean("KEY_HC_SNS_USER_SCROLL_THR", WXHardCoderJNI.hcSNSUserScrollThr);
    paramEditor.putInt("KEY_HC_SNS_USER_SCROLL_TIMEOUT", WXHardCoderJNI.hcSNSUserScrollTimeout);
    paramEditor.putLong("KEY_HC_SNS_USER_SCROLL_ACTION", WXHardCoderJNI.hcSNSUserScrollAction);
    paramEditor.putBoolean("KEY_HC_SNS_MSG_SCROLL_ENABLE", WXHardCoderJNI.hcSNSMsgScrollEnable);
    paramEditor.putInt("KEY_HC_SNS_MSG_SCROLL_DELEY", WXHardCoderJNI.hcSNSMsgScrollDelay);
    paramEditor.putInt("KEY_HC_SNS_MSG_SCROLL_CPU", WXHardCoderJNI.hcSNSMsgScrollCPU);
    paramEditor.putInt("KEY_HC_SNS_MSG_SCROLL_IO", WXHardCoderJNI.hcSNSMsgScrollIO);
    paramEditor.putBoolean("KEY_HC_SNS_MSG_SCROLL_THR", WXHardCoderJNI.hcSNSMsgScrollThr);
    paramEditor.putInt("KEY_HC_SNS_MSG_SCROLL_TIMEOUT", WXHardCoderJNI.hcSNSMsgScrollTimeout);
    paramEditor.putLong("KEY_HC_SNS_MSG_SCROLL_ACTION", WXHardCoderJNI.hcSNSMsgScrollAction);
    paramEditor.putBoolean("KEY_HC_MEDIA_GALLERY_SCROLL_ENABLE", WXHardCoderJNI.hcMediaGalleryScrollEnable);
    paramEditor.putInt("KEY_HC_MEDIA_GALLERY_SCROLL_DELEY", WXHardCoderJNI.hcMediaGalleryScrollDelay);
    paramEditor.putInt("KEY_HC_MEDIA_GALLERY_SCROLL_CPU", WXHardCoderJNI.hcMediaGalleryScrollCPU);
    paramEditor.putInt("KEY_HC_MEDIA_GALLERY_SCROLL_IO", WXHardCoderJNI.hcMediaGalleryScrollIO);
    paramEditor.putBoolean("KEY_HC_MEDIA_GALLERY_SCROLL_THR", WXHardCoderJNI.hcMediaGalleryScrollThr);
    paramEditor.putInt("KEY_HC_MEDIA_GALLERY_SCROLL_TIMEOUT", WXHardCoderJNI.hcMediaGalleryScrollTimeout);
    paramEditor.putLong("KEY_HC_MEDIA_GALLERY_SCROLL_ACTION", WXHardCoderJNI.hcMediaGalleryScrollAction);
    paramEditor.putBoolean("KEY_HCALBUM_SCROLL_ENABLE", WXHardCoderJNI.hcAlbumScrollEnable);
    paramEditor.putInt("KEY_HC_ALBUM_SCROLL_DELEY", WXHardCoderJNI.hcAlbumScrollDelay);
    paramEditor.putInt("KEY_HC_ALBUM_SCROLL_CPU", WXHardCoderJNI.hcAlbumScrollCPU);
    paramEditor.putInt("KEY_HC_ALBUM_SCROLL_IO", WXHardCoderJNI.hcAlbumScrollIO);
    paramEditor.putBoolean("KEY_HC_ALBUM_SCROLL_THR", WXHardCoderJNI.hcAlbumScrollThr);
    paramEditor.putInt("KEY_HC_ALBUM_SCROLL_TIMEOUT", WXHardCoderJNI.hcAlbumScrollTimeout);
    paramEditor.putLong("KEY_HC_ALBUM_SCROLL_ACTION", WXHardCoderJNI.hcAlbumScrollAction);
    paramEditor.apply();
    AppMethodBeat.o(39068);
  }
  
  private static String h(Context paramContext, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(39069);
    String str1 = ac.g(paramContext.getSharedPreferences(aj.fkC(), 0));
    String str2 = ac.fks();
    if ((!str1.equalsIgnoreCase("zh_CN")) && ((!str1.equalsIgnoreCase("language_default")) || (!"zh_CN".equalsIgnoreCase(str2))))
    {
      paramContext = DateFormat.getTimeInstance(3, ac.aQq(str1)).format(new Time(paramInt1, paramInt2, 0));
      AppMethodBeat.o(39069);
      return paramContext;
    }
    if (paramInt1 > 12) {}
    for (int i = paramInt1 - 12;; i = paramInt1)
    {
      paramContext = i.u(paramContext, paramInt1 * 3600000L + paramInt2 * 60000L) + String.format("%02d:%02d", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt2) });
      AppMethodBeat.o(39069);
      return paramContext;
    }
  }
  
  public int getLayoutId()
  {
    return 2131494430;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(39065);
    super.onCreate(paramBundle);
    setMMTitle(2131763241);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(39059);
        HardCoderSettingUI.this.finish();
        AppMethodBeat.o(39059);
        return true;
      }
    });
    paramBundle = getContext().getSharedPreferences("hardcoder_setting", 0);
    if (!paramBundle.contains("KEY_HC_ENABLE")) {
      b(paramBundle.edit().putBoolean("KEY_HC_ENABLE", true));
    }
    this.KFy = ((CheckBox)findViewById(2131298223));
    this.KFy.setChecked(WXHardCoderJNI.getDebug());
    this.KFw = ((CheckBox)findViewById(2131298229));
    this.KFw.setChecked(WXHardCoderJNI.getEnable());
    this.KFx = ((EditText)findViewById(2131304148));
    this.KFx.setText(WXHardCoderJNI.hcRetryInterval);
    this.KFz = ((CheckBox)findViewById(2131298221));
    this.KFA = ((CheckBox)findViewById(2131298225));
    this.KFA.setChecked(WXHardCoderJNI.hcTimeLimit);
    this.KFB = ((TextView)findViewById(2131297199));
    this.KFC = ((TextView)findViewById(2131299490));
    this.KFB.setText(h(this, WXHardCoderJNI.hcBeginTimeHour, WXHardCoderJNI.hcBeginTimeMin));
    this.KFC.setText(h(this, WXHardCoderJNI.hcEndTimeHour, WXHardCoderJNI.hcEndTimeMin));
    this.KFB.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(39060);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/tools/HardCoderSettingUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        HardCoderSettingUI.a(HardCoderSettingUI.this, true);
        HardCoderSettingUI.this.showDialog(1);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/tools/HardCoderSettingUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(39060);
      }
    });
    this.KFC.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(39061);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/tools/HardCoderSettingUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        HardCoderSettingUI.a(HardCoderSettingUI.this, false);
        HardCoderSettingUI.this.showDialog(1);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/tools/HardCoderSettingUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(39061);
      }
    });
    this.KFD = ((CheckBox)findViewById(2131298218));
    this.KFD.setChecked(WXHardCoderJNI.hcBootEnable);
    this.KFE = ((EditText)findViewById(2131298965));
    this.KFE.setText(WXHardCoderJNI.hcBootDelay);
    this.KFF = ((EditText)findViewById(2131305827));
    this.KFF.setText(WXHardCoderJNI.hcBootTimeout);
    this.KFF.setSelection(this.KFF.getText().length());
    this.KFG = ((EditText)findViewById(2131296353));
    this.KFG.setText(WXHardCoderJNI.hcBootAction);
    this.KFH = ((Spinner)findViewById(2131298836));
    this.KFH.setSelection(WXHardCoderJNI.hcBootCPU);
    this.KFI = ((Spinner)findViewById(2131301102));
    this.KFI.setSelection(WXHardCoderJNI.hcBootIO);
    this.KFJ = ((CheckBox)findViewById(2131305775));
    this.KFJ.setChecked(WXHardCoderJNI.hcBootThr);
    this.KFK = ((CheckBox)findViewById(2131298226));
    this.KFK.setChecked(WXHardCoderJNI.hcEnterChattingEnable);
    this.KFL = ((EditText)findViewById(2131298969));
    this.KFL.setText(WXHardCoderJNI.hcEnterChattingDelay);
    this.KFM = ((EditText)findViewById(2131305831));
    this.KFM.setText(WXHardCoderJNI.hcEnterChattingTimeout);
    this.KFM.setSelection(this.KFM.getText().length());
    this.KFN = ((EditText)findViewById(2131296363));
    this.KFN.setText(WXHardCoderJNI.hcEnterChattingAction);
    this.KFO = ((Spinner)findViewById(2131298839));
    this.KFO.setSelection(WXHardCoderJNI.hcEnterChattingCPU);
    this.KFP = ((Spinner)findViewById(2131301105));
    this.KFP.setSelection(WXHardCoderJNI.hcEnterChattingIO);
    this.KFQ = ((CheckBox)findViewById(2131305778));
    this.KFQ.setChecked(WXHardCoderJNI.hcEnterChattingThr);
    this.KFR = ((CheckBox)findViewById(2131298236));
    this.KFR.setChecked(WXHardCoderJNI.hcQuitChattingEnable);
    this.KFS = ((EditText)findViewById(2131298973));
    this.KFS.setText(WXHardCoderJNI.hcQuitChattingDelay);
    this.KFT = ((EditText)findViewById(2131305835));
    this.KFT.setText(WXHardCoderJNI.hcQuitChattingTimeout);
    this.KFT.setSelection(this.KFT.getText().length());
    this.KFU = ((EditText)findViewById(2131296378));
    this.KFU.setText(WXHardCoderJNI.hcQuitChattingAction);
    this.KFV = ((Spinner)findViewById(2131298843));
    this.KFV.setSelection(WXHardCoderJNI.hcQuitChattingCPU);
    this.KFW = ((Spinner)findViewById(2131301109));
    this.KFW.setSelection(WXHardCoderJNI.hcQuitChattingIO);
    this.KFX = ((CheckBox)findViewById(2131305782));
    this.KFX.setChecked(WXHardCoderJNI.hcQuitChattingThr);
    this.KFY = ((CheckBox)findViewById(2131298239));
    this.KFY.setChecked(WXHardCoderJNI.hcSendMsgEnable);
    this.KFZ = ((EditText)findViewById(2131298975));
    this.KFZ.setText(WXHardCoderJNI.hcSendMsgDelay);
    this.KGa = ((EditText)findViewById(2131305837));
    this.KGa.setText(WXHardCoderJNI.hcSendMsgTimeout);
    this.KGa.setSelection(this.KGa.getText().length());
    this.KGb = ((EditText)findViewById(2131296381));
    this.KGb.setText(WXHardCoderJNI.hcSendMsgAction);
    this.KGc = ((Spinner)findViewById(2131298845));
    this.KGc.setSelection(WXHardCoderJNI.hcSendMsgCPU);
    this.KGd = ((Spinner)findViewById(2131301111));
    this.KGd.setSelection(WXHardCoderJNI.hcSendMsgIO);
    this.KGe = ((CheckBox)findViewById(2131305784));
    this.KGe.setChecked(WXHardCoderJNI.hcSendMsgThr);
    this.KGf = ((CheckBox)findViewById(2131298240));
    this.KGf.setChecked(WXHardCoderJNI.hcSendPicMsgEnable);
    this.KGg = ((EditText)findViewById(2131298976));
    this.KGg.setText(WXHardCoderJNI.hcSendPicMsgDelay);
    this.KGh = ((EditText)findViewById(2131305838));
    this.KGh.setText(WXHardCoderJNI.hcSendPicMsgTimeout);
    this.KGh.setSelection(this.KGh.getText().length());
    this.KGi = ((EditText)findViewById(2131296382));
    this.KGi.setText(WXHardCoderJNI.hcSendPicMsgAction);
    this.KGj = ((Spinner)findViewById(2131298846));
    this.KGj.setSelection(WXHardCoderJNI.hcSendPicMsgCPU);
    this.KGk = ((Spinner)findViewById(2131301112));
    this.KGk.setSelection(WXHardCoderJNI.hcSendPicMsgIO);
    this.KGl = ((CheckBox)findViewById(2131305785));
    this.KGl.setChecked(WXHardCoderJNI.hcSendPicMsgThr);
    this.KGm = ((CheckBox)findViewById(2131298237));
    this.KGm.setChecked(WXHardCoderJNI.hcReceiveMsgEnable);
    this.KGn = ((EditText)findViewById(2131298974));
    this.KGn.setText(WXHardCoderJNI.hcReceiveMsgDelay);
    this.KGo = ((EditText)findViewById(2131305836));
    this.KGo.setText(WXHardCoderJNI.hcReceiveMsgTimeout);
    this.KGo.setSelection(this.KGo.getText().length());
    this.KGp = ((EditText)findViewById(2131296379));
    this.KGp.setText(WXHardCoderJNI.hcReceiveMsgAction);
    this.KGq = ((Spinner)findViewById(2131298844));
    this.KGq.setSelection(WXHardCoderJNI.hcReceiveMsgCPU);
    this.KGr = ((Spinner)findViewById(2131301110));
    this.KGr.setSelection(WXHardCoderJNI.hcReceiveMsgIO);
    this.KGs = ((CheckBox)findViewById(2131305783));
    this.KGs.setChecked(WXHardCoderJNI.hcReceiveMsgThr);
    this.KGt = ((CheckBox)findViewById(2131298253));
    this.KGt.setChecked(WXHardCoderJNI.hcUpdateChatroomEnable);
    this.KGu = ((EditText)findViewById(2131298980));
    this.KGu.setText(WXHardCoderJNI.hcUpdateChatroomDelay);
    this.KGv = ((EditText)findViewById(2131305842));
    this.KGv.setText(WXHardCoderJNI.hcUpdateChatroomTimeout);
    this.KGv.setSelection(this.KGv.getText().length());
    this.KGw = ((EditText)findViewById(2131296392));
    this.KGw.setText(WXHardCoderJNI.hcUpdateChatroomAction);
    this.KGx = ((Spinner)findViewById(2131298850));
    this.KGx.setSelection(WXHardCoderJNI.hcUpdateChatroomCPU);
    this.KGy = ((Spinner)findViewById(2131301116));
    this.KGy.setSelection(WXHardCoderJNI.hcUpdateChatroomIO);
    this.KGz = ((CheckBox)findViewById(2131305789));
    this.KGz.setChecked(WXHardCoderJNI.hcUpdateChatroomThr);
    this.KGA = ((EditText)findViewById(2131306202));
    this.KGA.setText(WXHardCoderJNI.hcUpdateChatroomMemberCount);
    this.KGB = ((CheckBox)findViewById(2131298222));
    this.KGB.setChecked(WXHardCoderJNI.hcDBEnable);
    this.KGC = ((EditText)findViewById(2131298966));
    this.KGC.setText(WXHardCoderJNI.hcDBDelayQuery);
    this.KGD = ((EditText)findViewById(2131298967));
    this.KGD.setText(WXHardCoderJNI.hcDBDelayWrite);
    this.KGE = ((EditText)findViewById(2131305828));
    this.KGE.setText(WXHardCoderJNI.hcDBTimeout);
    this.KGF = ((EditText)findViewById(2131305829));
    this.KGF.setText(WXHardCoderJNI.hcDBTimeoutBusy);
    this.KGG = ((EditText)findViewById(2131296358));
    this.KGG.setText(WXHardCoderJNI.hcDBActionQuery);
    this.KGH = ((EditText)findViewById(2131296359));
    this.KGH.setText(WXHardCoderJNI.hcDBActionWrite);
    this.KGI = ((Spinner)findViewById(2131298837));
    this.KGI.setSelection(WXHardCoderJNI.hcDBCPU);
    this.KGJ = ((Spinner)findViewById(2131301103));
    this.KGJ.setSelection(WXHardCoderJNI.hcDBIO);
    this.KGK = ((CheckBox)findViewById(2131305776));
    this.KGK.setChecked(WXHardCoderJNI.hcDBThr);
    this.KGL = ((CheckBox)findViewById(2131298254));
    this.KGL.setChecked(WXHardCoderJNI.hcEncodeVideoEnable);
    this.KGM = ((EditText)findViewById(2131298981));
    this.KGM.setText(WXHardCoderJNI.hcEncodeVideoDelay);
    this.KGN = ((EditText)findViewById(2131305843));
    this.KGN.setText(WXHardCoderJNI.hcEncodeVideoTimeout);
    this.KGO = ((EditText)findViewById(2131296393));
    this.KGO.setText(WXHardCoderJNI.hcEncodeVideoAction);
    this.KGP = ((Spinner)findViewById(2131298851));
    this.KGP.setSelection(WXHardCoderJNI.hcEncodeVideoCPU);
    this.KGQ = ((Spinner)findViewById(2131301117));
    this.KGQ.setSelection(WXHardCoderJNI.hcEncodeVideoIO);
    this.KGR = ((CheckBox)findViewById(2131305790));
    this.KGR.setChecked(WXHardCoderJNI.hcEncodeVideoThr);
    this.KGS = ((CheckBox)findViewById(2131298224));
    this.KGS.setChecked(WXHardCoderJNI.hcDecodePicEnable);
    this.KGT = ((EditText)findViewById(2131298968));
    this.KGT.setText(WXHardCoderJNI.hcDecodePicDelay);
    this.KGU = ((EditText)findViewById(2131305830));
    this.KGU.setText(WXHardCoderJNI.hcDecodePicTimeout);
    this.KGV = ((EditText)findViewById(2131296360));
    this.KGV.setText(WXHardCoderJNI.hcDecodePicAction);
    this.KGW = ((Spinner)findViewById(2131298838));
    this.KGW.setSelection(WXHardCoderJNI.hcDecodePicCPU);
    this.KGX = ((Spinner)findViewById(2131301104));
    this.KGX.setSelection(WXHardCoderJNI.hcDecodePicIO);
    this.KGY = ((CheckBox)findViewById(2131305777));
    this.KGY.setChecked(WXHardCoderJNI.hcDecodePicThr);
    this.KGZ = ((CheckBox)findViewById(2131298227));
    this.KGZ.setChecked(WXHardCoderJNI.hcGifEnable);
    this.KHa = ((EditText)findViewById(2131298970));
    this.KHa.setText(WXHardCoderJNI.hcGifDelay);
    this.KHb = ((EditText)findViewById(2131305832));
    this.KHb.setText(WXHardCoderJNI.hcGifTimeout);
    this.KHc = ((EditText)findViewById(2131296364));
    this.KHc.setText(WXHardCoderJNI.hcGifAction);
    this.KHd = ((Spinner)findViewById(2131298840));
    this.KHd.setSelection(WXHardCoderJNI.hcGifCPU);
    this.KHe = ((Spinner)findViewById(2131301106));
    this.KHe.setSelection(WXHardCoderJNI.hcGifIO);
    this.KHf = ((CheckBox)findViewById(2131305779));
    this.KHf.setChecked(WXHardCoderJNI.hcGifThr);
    this.KHg = ((CheckBox)findViewById(2131298228));
    this.KHg.setChecked(WXHardCoderJNI.hcGifFrameEnable);
    this.KHh = ((EditText)findViewById(2131298971));
    this.KHh.setText(WXHardCoderJNI.hcGifFrameDelay);
    this.KHi = ((EditText)findViewById(2131305833));
    this.KHi.setText(WXHardCoderJNI.hcGifFrameTimeout);
    this.KHj = ((EditText)findViewById(2131296365));
    this.KHj.setText(WXHardCoderJNI.hcGifFrameAction);
    this.KHk = ((Spinner)findViewById(2131298841));
    this.KHk.setSelection(WXHardCoderJNI.hcGifFrameCPU);
    this.KHl = ((Spinner)findViewById(2131301107));
    this.KHl.setSelection(WXHardCoderJNI.hcGifFrameIO);
    this.KHm = ((CheckBox)findViewById(2131305780));
    this.KHm.setChecked(WXHardCoderJNI.hcGifFrameThr);
    this.KHn = ((CheckBox)findViewById(2131298244));
    this.KHn.setChecked(WXHardCoderJNI.hcSNSScrollEnable);
    this.KHo = ((EditText)findViewById(2131298978));
    this.KHo.setText(WXHardCoderJNI.hcSNSScrollDelay);
    this.KHp = ((EditText)findViewById(2131305840));
    this.KHp.setText(WXHardCoderJNI.hcSNSScrollTimeout);
    this.KHq = ((EditText)findViewById(2131296385));
    this.KHq.setText(WXHardCoderJNI.hcSNSScrollAction);
    this.KHr = ((Spinner)findViewById(2131298848));
    this.KHr.setSelection(WXHardCoderJNI.hcSNSScrollCPU);
    this.KHs = ((Spinner)findViewById(2131301114));
    this.KHs.setSelection(WXHardCoderJNI.hcSNSScrollIO);
    this.KHt = ((CheckBox)findViewById(2131305787));
    this.KHt.setChecked(WXHardCoderJNI.hcSNSScrollThr);
    this.KHu = ((CheckBox)findViewById(2131298245));
    this.KHu.setChecked(WXHardCoderJNI.hcSNSUserScrollEnable);
    this.KHv = ((EditText)findViewById(2131298979));
    this.KHv.setText(WXHardCoderJNI.hcSNSUserScrollDelay);
    this.KHw = ((EditText)findViewById(2131305841));
    this.KHw.setText(WXHardCoderJNI.hcSNSUserScrollTimeout);
    this.KHx = ((EditText)findViewById(2131296386));
    this.KHx.setText(WXHardCoderJNI.hcSNSUserScrollAction);
    this.KHy = ((Spinner)findViewById(2131298849));
    this.KHy.setSelection(WXHardCoderJNI.hcSNSUserScrollCPU);
    this.KHz = ((Spinner)findViewById(2131301115));
    this.KHz.setSelection(WXHardCoderJNI.hcSNSUserScrollIO);
    this.KHA = ((CheckBox)findViewById(2131305788));
    this.KHA.setChecked(WXHardCoderJNI.hcSNSUserScrollThr);
    this.KHB = ((CheckBox)findViewById(2131298243));
    this.KHB.setChecked(WXHardCoderJNI.hcSNSMsgScrollEnable);
    this.KHC = ((EditText)findViewById(2131298977));
    this.KHC.setText(WXHardCoderJNI.hcSNSMsgScrollDelay);
    this.KHD = ((EditText)findViewById(2131305839));
    this.KHD.setText(WXHardCoderJNI.hcSNSMsgScrollTimeout);
    this.KHE = ((EditText)findViewById(2131296384));
    this.KHE.setText(WXHardCoderJNI.hcSNSMsgScrollAction);
    this.KHF = ((Spinner)findViewById(2131298847));
    this.KHF.setSelection(WXHardCoderJNI.hcSNSMsgScrollCPU);
    this.KHG = ((Spinner)findViewById(2131301113));
    this.KHG.setSelection(WXHardCoderJNI.hcSNSMsgScrollIO);
    this.KHH = ((CheckBox)findViewById(2131305786));
    this.KHH.setChecked(WXHardCoderJNI.hcSNSMsgScrollThr);
    this.KHI = ((CheckBox)findViewById(2131298231));
    this.KHI.setChecked(WXHardCoderJNI.hcMediaGalleryScrollEnable);
    this.KHJ = ((EditText)findViewById(2131298972));
    this.KHJ.setText(WXHardCoderJNI.hcMediaGalleryScrollDelay);
    this.KHK = ((EditText)findViewById(2131305834));
    this.KHK.setText(WXHardCoderJNI.hcMediaGalleryScrollTimeout);
    this.KHL = ((EditText)findViewById(2131296368));
    this.KHL.setText(WXHardCoderJNI.hcMediaGalleryScrollAction);
    this.KHM = ((Spinner)findViewById(2131298842));
    this.KHM.setSelection(WXHardCoderJNI.hcMediaGalleryScrollCPU);
    this.KHN = ((Spinner)findViewById(2131301108));
    this.KHN.setSelection(WXHardCoderJNI.hcMediaGalleryScrollIO);
    this.KHO = ((CheckBox)findViewById(2131305781));
    this.KHO.setChecked(WXHardCoderJNI.hcMediaGalleryScrollThr);
    this.KHP = ((CheckBox)findViewById(2131298216));
    this.KHP.setChecked(WXHardCoderJNI.hcAlbumScrollEnable);
    this.KHQ = ((EditText)findViewById(2131298963));
    this.KHQ.setText(WXHardCoderJNI.hcAlbumScrollDelay);
    this.KHR = ((EditText)findViewById(2131305825));
    this.KHR.setText(WXHardCoderJNI.hcAlbumScrollTimeout);
    this.KHS = ((EditText)findViewById(2131296342));
    this.KHS.setText(WXHardCoderJNI.hcAlbumScrollAction);
    this.KHT = ((Spinner)findViewById(2131298834));
    this.KHT.setSelection(WXHardCoderJNI.hcAlbumScrollCPU);
    this.KHU = ((Spinner)findViewById(2131301100));
    this.KHU.setSelection(WXHardCoderJNI.hcAlbumScrollIO);
    this.KHV = ((CheckBox)findViewById(2131305773));
    this.KHV.setChecked(WXHardCoderJNI.hcAlbumScrollThr);
    this.KHW = ((CheckBox)findViewById(2131298217));
    this.KHW.setChecked(WXHardCoderJNI.hcBizEnable);
    this.KHX = ((EditText)findViewById(2131298964));
    this.KHX.setText(WXHardCoderJNI.hcBizDelay);
    this.KHY = ((EditText)findViewById(2131305826));
    this.KHY.setText(WXHardCoderJNI.hcBizTimeout);
    this.KHZ = ((EditText)findViewById(2131296352));
    this.KHZ.setText(WXHardCoderJNI.hcBizAction);
    this.KIa = ((Spinner)findViewById(2131298835));
    this.KIa.setSelection(WXHardCoderJNI.hcBizCPU);
    this.KIb = ((Spinner)findViewById(2131301101));
    this.KIb.setSelection(WXHardCoderJNI.hcBizIO);
    this.KIc = ((CheckBox)findViewById(2131305774));
    this.KIc.setChecked(WXHardCoderJNI.hcBizThr);
    this.KFw.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(39062);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/tools/HardCoderSettingUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        boolean bool = HardCoderSettingUI.a(HardCoderSettingUI.this).isChecked();
        HardCoderSettingUI.b(HardCoderSettingUI.this).setChecked(bool);
        HardCoderSettingUI.c(HardCoderSettingUI.this).setChecked(bool);
        HardCoderSettingUI.d(HardCoderSettingUI.this).setChecked(bool);
        HardCoderSettingUI.e(HardCoderSettingUI.this).setChecked(bool);
        HardCoderSettingUI.f(HardCoderSettingUI.this).setChecked(bool);
        HardCoderSettingUI.g(HardCoderSettingUI.this).setChecked(bool);
        HardCoderSettingUI.h(HardCoderSettingUI.this).setChecked(bool);
        HardCoderSettingUI.i(HardCoderSettingUI.this).setChecked(bool);
        HardCoderSettingUI.j(HardCoderSettingUI.this).setChecked(bool);
        HardCoderSettingUI.k(HardCoderSettingUI.this).setChecked(bool);
        HardCoderSettingUI.l(HardCoderSettingUI.this).setChecked(bool);
        HardCoderSettingUI.m(HardCoderSettingUI.this).setChecked(bool);
        HardCoderSettingUI.n(HardCoderSettingUI.this).setChecked(bool);
        HardCoderSettingUI.o(HardCoderSettingUI.this).setChecked(bool);
        HardCoderSettingUI.p(HardCoderSettingUI.this).setChecked(bool);
        HardCoderSettingUI.q(HardCoderSettingUI.this).setChecked(bool);
        HardCoderSettingUI.r(HardCoderSettingUI.this).setChecked(bool);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/tools/HardCoderSettingUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(39062);
      }
    });
    AppMethodBeat.o(39065);
  }
  
  protected Dialog onCreateDialog(int paramInt)
  {
    AppMethodBeat.i(39066);
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(39066);
      return null;
    }
    if (this.yGi)
    {
      localTimePickerDialog = new TimePickerDialog(getContext(), this.yGj, WXHardCoderJNI.hcBeginTimeHour, WXHardCoderJNI.hcBeginTimeMin, false);
      AppMethodBeat.o(39066);
      return localTimePickerDialog;
    }
    TimePickerDialog localTimePickerDialog = new TimePickerDialog(getContext(), this.yGj, WXHardCoderJNI.hcEndTimeHour, WXHardCoderJNI.hcBeginTimeMin, false);
    AppMethodBeat.o(39066);
    return localTimePickerDialog;
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(39067);
    ad.i("HardCoderSettingUI", "save");
    if ((this.KFw.isChecked()) && (!WXHardCoderJNI.getEnable()))
    {
      WXHardCoderJNI.setHcEnable(this.KFw.isChecked());
      WXHardCoderJNI.initHardCoder(com.tencent.mm.plugin.hardcoder.a.dbW(), com.tencent.mm.plugin.hardcoder.a.dbW(), null);
    }
    WXHardCoderJNI.setDebug(this.KFy.isChecked());
    WXHardCoderJNI.setHcEnable(this.KFw.isChecked());
    WXHardCoderJNI.hcRetryInterval = bt.getInt(this.KFx.getText().toString(), WXHardCoderJNI.hcRetryInterval);
    if (WXHardCoderJNI.isCheckEnv())
    {
      WXHardCoderJNI.setDebug(WXHardCoderJNI.getDebug());
      WXHardCoderJNI.setHcEnable(WXHardCoderJNI.getEnable());
      WXHardCoderJNI.setRetryConnectInterval(WXHardCoderJNI.hcRetryInterval);
    }
    WXHardCoderJNI.hcTimeLimit = this.KFA.isChecked();
    WXHardCoderJNI.hcBootEnable = this.KFD.isChecked();
    WXHardCoderJNI.hcBootDelay = bt.getInt(this.KFE.getText().toString(), WXHardCoderJNI.hcBootDelay);
    WXHardCoderJNI.hcBootCPU = this.KFH.getSelectedItemPosition();
    WXHardCoderJNI.hcBootIO = this.KFI.getSelectedItemPosition();
    WXHardCoderJNI.hcBootThr = this.KFJ.isChecked();
    WXHardCoderJNI.hcBootTimeout = bt.getInt(this.KFF.getText().toString(), WXHardCoderJNI.hcBootTimeout);
    WXHardCoderJNI.hcBootAction = bt.getLong(this.KFG.getText().toString(), WXHardCoderJNI.hcBootAction);
    WXHardCoderJNI.hcEnterChattingEnable = this.KFK.isChecked();
    WXHardCoderJNI.hcEnterChattingDelay = bt.getInt(this.KFL.getText().toString(), WXHardCoderJNI.hcEnterChattingDelay);
    WXHardCoderJNI.hcEnterChattingCPU = this.KFO.getSelectedItemPosition();
    WXHardCoderJNI.hcEnterChattingIO = this.KFP.getSelectedItemPosition();
    WXHardCoderJNI.hcEnterChattingThr = this.KFQ.isChecked();
    WXHardCoderJNI.hcEnterChattingTimeout = bt.getInt(this.KFM.getText().toString(), WXHardCoderJNI.hcEnterChattingTimeout);
    WXHardCoderJNI.hcEnterChattingAction = bt.getLong(this.KFN.getText().toString(), WXHardCoderJNI.hcEnterChattingAction);
    WXHardCoderJNI.hcQuitChattingEnable = this.KFR.isChecked();
    WXHardCoderJNI.hcQuitChattingDelay = bt.getInt(this.KFS.getText().toString(), WXHardCoderJNI.hcQuitChattingDelay);
    WXHardCoderJNI.hcQuitChattingCPU = this.KFV.getSelectedItemPosition();
    WXHardCoderJNI.hcQuitChattingIO = this.KFW.getSelectedItemPosition();
    WXHardCoderJNI.hcQuitChattingThr = this.KFX.isChecked();
    WXHardCoderJNI.hcQuitChattingTimeout = bt.getInt(this.KFT.getText().toString(), WXHardCoderJNI.hcQuitChattingTimeout);
    WXHardCoderJNI.hcQuitChattingAction = bt.getLong(this.KFU.getText().toString(), WXHardCoderJNI.hcQuitChattingAction);
    WXHardCoderJNI.hcSendMsgEnable = this.KFY.isChecked();
    WXHardCoderJNI.hcSendMsgDelay = bt.getInt(this.KFZ.getText().toString(), WXHardCoderJNI.hcSendMsgDelay);
    WXHardCoderJNI.hcSendMsgCPU = this.KGc.getSelectedItemPosition();
    WXHardCoderJNI.hcSendMsgIO = this.KGd.getSelectedItemPosition();
    WXHardCoderJNI.hcSendMsgThr = this.KGe.isChecked();
    WXHardCoderJNI.hcSendMsgTimeout = bt.getInt(this.KGa.getText().toString(), WXHardCoderJNI.hcSendMsgTimeout);
    WXHardCoderJNI.hcSendMsgAction = bt.getLong(this.KGb.getText().toString(), WXHardCoderJNI.hcSendMsgAction);
    WXHardCoderJNI.hcSendPicMsgEnable = this.KGf.isChecked();
    WXHardCoderJNI.hcSendPicMsgDelay = bt.getInt(this.KGg.getText().toString(), WXHardCoderJNI.hcSendPicMsgDelay);
    WXHardCoderJNI.hcSendPicMsgCPU = this.KGj.getSelectedItemPosition();
    WXHardCoderJNI.hcSendPicMsgIO = this.KGk.getSelectedItemPosition();
    WXHardCoderJNI.hcSendPicMsgThr = this.KGl.isChecked();
    WXHardCoderJNI.hcSendPicMsgTimeout = bt.getInt(this.KGh.getText().toString(), WXHardCoderJNI.hcSendPicMsgTimeout);
    WXHardCoderJNI.hcSendPicMsgAction = bt.getLong(this.KGi.getText().toString(), WXHardCoderJNI.hcSendPicMsgAction);
    WXHardCoderJNI.hcReceiveMsgEnable = this.KGm.isChecked();
    WXHardCoderJNI.hcReceiveMsgDelay = bt.getInt(this.KGn.getText().toString(), WXHardCoderJNI.hcReceiveMsgDelay);
    WXHardCoderJNI.hcReceiveMsgCPU = this.KGq.getSelectedItemPosition();
    WXHardCoderJNI.hcReceiveMsgIO = this.KGr.getSelectedItemPosition();
    WXHardCoderJNI.hcReceiveMsgThr = this.KGs.isChecked();
    WXHardCoderJNI.hcReceiveMsgTimeout = bt.getInt(this.KGo.getText().toString(), WXHardCoderJNI.hcReceiveMsgTimeout);
    WXHardCoderJNI.hcReceiveMsgAction = bt.getLong(this.KGp.getText().toString(), WXHardCoderJNI.hcReceiveMsgAction);
    WXHardCoderJNI.hcUpdateChatroomEnable = this.KGt.isChecked();
    WXHardCoderJNI.hcUpdateChatroomDelay = bt.getInt(this.KGu.getText().toString(), WXHardCoderJNI.hcUpdateChatroomDelay);
    WXHardCoderJNI.hcUpdateChatroomCPU = this.KGx.getSelectedItemPosition();
    WXHardCoderJNI.hcUpdateChatroomIO = this.KGy.getSelectedItemPosition();
    WXHardCoderJNI.hcUpdateChatroomThr = this.KGz.isChecked();
    WXHardCoderJNI.hcUpdateChatroomTimeout = bt.getInt(this.KGv.getText().toString(), WXHardCoderJNI.hcUpdateChatroomTimeout);
    WXHardCoderJNI.hcUpdateChatroomAction = bt.getLong(this.KGw.getText().toString(), WXHardCoderJNI.hcUpdateChatroomAction);
    WXHardCoderJNI.hcUpdateChatroomMemberCount = bt.getLong(this.KGA.getText().toString(), WXHardCoderJNI.hcUpdateChatroomMemberCount);
    WXHardCoderJNI.hcDBEnable = this.KGB.isChecked();
    WXHardCoderJNI.hcDBDelayQuery = bt.getInt(this.KGC.getText().toString(), WXHardCoderJNI.hcDBDelayQuery);
    WXHardCoderJNI.hcDBDelayWrite = bt.getInt(this.KGD.getText().toString(), WXHardCoderJNI.hcDBDelayWrite);
    WXHardCoderJNI.hcDBCPU = this.KFH.getSelectedItemPosition();
    WXHardCoderJNI.hcDBIO = this.KFI.getSelectedItemPosition();
    WXHardCoderJNI.hcDBThr = this.KFJ.isChecked();
    WXHardCoderJNI.hcDBTimeout = bt.getInt(this.KGE.getText().toString(), WXHardCoderJNI.hcDBTimeout);
    WXHardCoderJNI.hcDBTimeoutBusy = bt.getInt(this.KGF.getText().toString(), WXHardCoderJNI.hcDBTimeoutBusy);
    WXHardCoderJNI.hcDBActionQuery = bt.getLong(this.KGG.getText().toString(), WXHardCoderJNI.hcDBActionQuery);
    WXHardCoderJNI.hcDBActionWrite = bt.getLong(this.KGH.getText().toString(), WXHardCoderJNI.hcDBActionWrite);
    WXHardCoderJNI.hcEncodeVideoEnable = this.KGL.isChecked();
    WXHardCoderJNI.hcEncodeVideoDelay = bt.getInt(this.KGM.getText().toString(), WXHardCoderJNI.hcEncodeVideoDelay);
    WXHardCoderJNI.hcEncodeVideoCPU = this.KGP.getSelectedItemPosition();
    WXHardCoderJNI.hcEncodeVideoIO = this.KGQ.getSelectedItemPosition();
    WXHardCoderJNI.hcEncodeVideoThr = this.KGR.isChecked();
    WXHardCoderJNI.hcEncodeVideoTimeout = bt.getInt(this.KGN.getText().toString(), WXHardCoderJNI.hcEncodeVideoTimeout);
    WXHardCoderJNI.hcEncodeVideoAction = bt.getLong(this.KGO.getText().toString(), WXHardCoderJNI.hcEncodeVideoAction);
    WXHardCoderJNI.hcDecodePicEnable = this.KGS.isChecked();
    WXHardCoderJNI.hcDecodePicDelay = bt.getInt(this.KGT.getText().toString(), WXHardCoderJNI.hcDecodePicDelay);
    WXHardCoderJNI.hcDecodePicCPU = this.KGW.getSelectedItemPosition();
    WXHardCoderJNI.hcDecodePicIO = this.KGX.getSelectedItemPosition();
    WXHardCoderJNI.hcDecodePicThr = this.KGY.isChecked();
    WXHardCoderJNI.hcDecodePicTimeout = bt.getInt(this.KGU.getText().toString(), WXHardCoderJNI.hcDecodePicTimeout);
    WXHardCoderJNI.hcDecodePicAction = bt.getLong(this.KGV.getText().toString(), WXHardCoderJNI.hcDecodePicAction);
    WXHardCoderJNI.hcGifEnable = this.KGZ.isChecked();
    WXHardCoderJNI.hcGifDelay = bt.getInt(this.KHa.getText().toString(), WXHardCoderJNI.hcGifDelay);
    WXHardCoderJNI.hcGifCPU = this.KHd.getSelectedItemPosition();
    WXHardCoderJNI.hcGifIO = this.KHe.getSelectedItemPosition();
    WXHardCoderJNI.hcGifThr = this.KHf.isChecked();
    WXHardCoderJNI.hcGifTimeout = bt.getInt(this.KHb.getText().toString(), WXHardCoderJNI.hcGifTimeout);
    WXHardCoderJNI.hcGifAction = bt.getLong(this.KHc.getText().toString(), WXHardCoderJNI.hcGifAction);
    WXHardCoderJNI.hcGifFrameEnable = this.KHg.isChecked();
    WXHardCoderJNI.hcGifFrameDelay = bt.getInt(this.KHh.getText().toString(), WXHardCoderJNI.hcGifFrameDelay);
    WXHardCoderJNI.hcGifFrameCPU = this.KHk.getSelectedItemPosition();
    WXHardCoderJNI.hcGifFrameIO = this.KHl.getSelectedItemPosition();
    WXHardCoderJNI.hcGifFrameThr = this.KHm.isChecked();
    WXHardCoderJNI.hcGifFrameTimeout = bt.getInt(this.KHi.getText().toString(), WXHardCoderJNI.hcGifFrameTimeout);
    WXHardCoderJNI.hcGifFrameAction = bt.getLong(this.KHj.getText().toString(), WXHardCoderJNI.hcGifFrameAction);
    WXHardCoderJNI.hcSNSScrollEnable = this.KHn.isChecked();
    WXHardCoderJNI.hcSNSScrollDelay = bt.getInt(this.KHo.getText().toString(), WXHardCoderJNI.hcSNSScrollDelay);
    WXHardCoderJNI.hcSNSScrollCPU = this.KHr.getSelectedItemPosition();
    WXHardCoderJNI.hcSNSScrollIO = this.KHs.getSelectedItemPosition();
    WXHardCoderJNI.hcSNSScrollThr = this.KHt.isChecked();
    WXHardCoderJNI.hcSNSScrollTimeout = bt.getInt(this.KHp.getText().toString(), WXHardCoderJNI.hcSNSScrollTimeout);
    WXHardCoderJNI.hcSNSScrollAction = bt.getLong(this.KHq.getText().toString(), WXHardCoderJNI.hcSNSScrollAction);
    WXHardCoderJNI.hcSNSUserScrollEnable = this.KHu.isChecked();
    WXHardCoderJNI.hcSNSUserScrollDelay = bt.getInt(this.KHv.getText().toString(), WXHardCoderJNI.hcSNSUserScrollDelay);
    WXHardCoderJNI.hcSNSUserScrollCPU = this.KHy.getSelectedItemPosition();
    WXHardCoderJNI.hcSNSUserScrollIO = this.KHz.getSelectedItemPosition();
    WXHardCoderJNI.hcSNSUserScrollThr = this.KHA.isChecked();
    WXHardCoderJNI.hcSNSUserScrollTimeout = bt.getInt(this.KHw.getText().toString(), WXHardCoderJNI.hcSNSUserScrollTimeout);
    WXHardCoderJNI.hcSNSUserScrollAction = bt.getLong(this.KHx.getText().toString(), WXHardCoderJNI.hcSNSUserScrollAction);
    WXHardCoderJNI.hcSNSMsgScrollEnable = this.KHB.isChecked();
    WXHardCoderJNI.hcSNSMsgScrollDelay = bt.getInt(this.KHC.getText().toString(), WXHardCoderJNI.hcSNSMsgScrollDelay);
    WXHardCoderJNI.hcSNSMsgScrollCPU = this.KHF.getSelectedItemPosition();
    WXHardCoderJNI.hcSNSMsgScrollIO = this.KHG.getSelectedItemPosition();
    WXHardCoderJNI.hcSNSMsgScrollThr = this.KHH.isChecked();
    WXHardCoderJNI.hcSNSMsgScrollTimeout = bt.getInt(this.KHD.getText().toString(), WXHardCoderJNI.hcSNSMsgScrollTimeout);
    WXHardCoderJNI.hcSNSMsgScrollAction = bt.getLong(this.KHE.getText().toString(), WXHardCoderJNI.hcSNSMsgScrollAction);
    WXHardCoderJNI.hcMediaGalleryScrollEnable = this.KHI.isChecked();
    WXHardCoderJNI.hcMediaGalleryScrollDelay = bt.getInt(this.KHJ.getText().toString(), WXHardCoderJNI.hcMediaGalleryScrollDelay);
    WXHardCoderJNI.hcMediaGalleryScrollCPU = this.KHM.getSelectedItemPosition();
    WXHardCoderJNI.hcMediaGalleryScrollIO = this.KHN.getSelectedItemPosition();
    WXHardCoderJNI.hcMediaGalleryScrollThr = this.KHO.isChecked();
    WXHardCoderJNI.hcMediaGalleryScrollTimeout = bt.getInt(this.KHK.getText().toString(), WXHardCoderJNI.hcMediaGalleryScrollTimeout);
    WXHardCoderJNI.hcMediaGalleryScrollAction = bt.getLong(this.KHL.getText().toString(), WXHardCoderJNI.hcMediaGalleryScrollAction);
    WXHardCoderJNI.hcAlbumScrollEnable = this.KHP.isChecked();
    WXHardCoderJNI.hcAlbumScrollDelay = bt.getInt(this.KHQ.getText().toString(), WXHardCoderJNI.hcAlbumScrollDelay);
    WXHardCoderJNI.hcAlbumScrollCPU = this.KHT.getSelectedItemPosition();
    WXHardCoderJNI.hcAlbumScrollIO = this.KHU.getSelectedItemPosition();
    WXHardCoderJNI.hcAlbumScrollThr = this.KHV.isChecked();
    WXHardCoderJNI.hcAlbumScrollTimeout = bt.getInt(this.KHR.getText().toString(), WXHardCoderJNI.hcAlbumScrollTimeout);
    WXHardCoderJNI.hcAlbumScrollAction = bt.getLong(this.KHS.getText().toString(), WXHardCoderJNI.hcAlbumScrollAction);
    WXHardCoderJNI.hcBizEnable = this.KHW.isChecked();
    WXHardCoderJNI.hcBizDelay = bt.getInt(this.KHX.getText().toString(), WXHardCoderJNI.hcBizDelay);
    WXHardCoderJNI.hcBizCPU = this.KIa.getSelectedItemPosition();
    WXHardCoderJNI.hcBizIO = this.KIb.getSelectedItemPosition();
    WXHardCoderJNI.hcBizThr = this.KIc.isChecked();
    WXHardCoderJNI.hcBizTimeout = bt.getInt(this.KHY.getText().toString(), WXHardCoderJNI.hcBizTimeout);
    WXHardCoderJNI.hcBizAction = bt.getLong(this.KHZ.getText().toString(), WXHardCoderJNI.hcBizAction);
    b(getContext().getSharedPreferences("hardcoder_setting", 0).edit());
    WXHardCoderJNI.reloadSPConfig(WXHardCoderJNI.RELOAD_SCENE_SETTING);
    super.onDestroy();
    AppMethodBeat.o(39067);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.tools.HardCoderSettingUI
 * JD-Core Version:    0.7.0.1
 */