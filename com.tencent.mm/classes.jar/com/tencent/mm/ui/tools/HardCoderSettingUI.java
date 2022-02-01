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
import com.tencent.mm.plugin.hardcoder.a;
import com.tencent.mm.pluginsdk.g.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;
import java.sql.Time;
import java.text.DateFormat;

public class HardCoderSettingUI
  extends MMActivity
{
  private EditText IOA;
  private EditText IOB;
  private Spinner IOC;
  private Spinner IOD;
  private CheckBox IOE;
  private CheckBox IOF;
  private EditText IOG;
  private EditText IOH;
  private EditText IOI;
  private Spinner IOJ;
  private Spinner IOK;
  private CheckBox IOL;
  private CheckBox IOM;
  private EditText ION;
  private EditText IOO;
  private EditText IOP;
  private Spinner IOQ;
  private Spinner IOR;
  private CheckBox IOT;
  private CheckBox IOU;
  private EditText IOV;
  private EditText IOW;
  private EditText IOX;
  private Spinner IOY;
  private Spinner IOZ;
  private CheckBox IOr;
  private EditText IOs;
  private CheckBox IOt;
  private CheckBox IOu;
  private CheckBox IOv;
  private TextView IOw;
  private TextView IOx;
  private CheckBox IOy;
  private EditText IOz;
  private EditText IPA;
  private EditText IPB;
  private EditText IPC;
  private EditText IPD;
  private Spinner IPE;
  private Spinner IPF;
  private CheckBox IPG;
  private CheckBox IPH;
  private EditText IPI;
  private EditText IPJ;
  private EditText IPK;
  private Spinner IPL;
  private Spinner IPM;
  private CheckBox IPN;
  private CheckBox IPO;
  private EditText IPP;
  private EditText IPQ;
  private EditText IPR;
  private Spinner IPS;
  private Spinner IPT;
  private CheckBox IPU;
  private CheckBox IPV;
  private EditText IPW;
  private EditText IPX;
  private EditText IPY;
  private Spinner IPZ;
  private CheckBox IPa;
  private CheckBox IPb;
  private EditText IPc;
  private EditText IPd;
  private EditText IPe;
  private Spinner IPf;
  private Spinner IPg;
  private CheckBox IPh;
  private CheckBox IPi;
  private EditText IPj;
  private EditText IPk;
  private EditText IPl;
  private Spinner IPm;
  private Spinner IPn;
  private CheckBox IPo;
  private CheckBox IPp;
  private EditText IPq;
  private EditText IPr;
  private EditText IPs;
  private Spinner IPt;
  private Spinner IPu;
  private CheckBox IPv;
  private EditText IPw;
  private CheckBox IPx;
  private EditText IPy;
  private EditText IPz;
  private EditText IQA;
  private Spinner IQB;
  private Spinner IQC;
  private CheckBox IQD;
  private CheckBox IQE;
  private EditText IQF;
  private EditText IQG;
  private EditText IQH;
  private Spinner IQI;
  private Spinner IQJ;
  private CheckBox IQK;
  private CheckBox IQL;
  private EditText IQM;
  private EditText IQN;
  private EditText IQO;
  private Spinner IQP;
  private Spinner IQQ;
  private CheckBox IQR;
  private CheckBox IQS;
  private EditText IQT;
  private EditText IQU;
  private EditText IQV;
  private Spinner IQW;
  private Spinner IQX;
  private CheckBox IQY;
  private Spinner IQa;
  private CheckBox IQb;
  private CheckBox IQc;
  private EditText IQd;
  private EditText IQe;
  private EditText IQf;
  private Spinner IQg;
  private Spinner IQh;
  private CheckBox IQi;
  private CheckBox IQj;
  private EditText IQk;
  private EditText IQl;
  private EditText IQm;
  private Spinner IQn;
  private Spinner IQo;
  private CheckBox IQp;
  private CheckBox IQq;
  private EditText IQr;
  private EditText IQs;
  private EditText IQt;
  private Spinner IQu;
  private Spinner IQv;
  private CheckBox IQw;
  private CheckBox IQx;
  private EditText IQy;
  private EditText IQz;
  private final TimePickerDialog.OnTimeSetListener xrA;
  private boolean xrz;
  
  public HardCoderSettingUI()
  {
    AppMethodBeat.i(39064);
    this.xrz = false;
    this.xrA = new TimePickerDialog.OnTimeSetListener()
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
  
  private static void a(SharedPreferences.Editor paramEditor)
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
    String str1 = ab.g(paramContext.getSharedPreferences(ai.eUX(), 0));
    String str2 = ab.eUO();
    if ((!str1.equalsIgnoreCase("zh_CN")) && ((!str1.equalsIgnoreCase("language_default")) || (!"zh_CN".equalsIgnoreCase(str2))))
    {
      paramContext = DateFormat.getTimeInstance(3, ab.aKK(str1)).format(new Time(paramInt1, paramInt2, 0));
      AppMethodBeat.o(39069);
      return paramContext;
    }
    if (paramInt1 > 12) {}
    for (int i = paramInt1 - 12;; i = paramInt1)
    {
      paramContext = h.u(paramContext, paramInt1 * 3600000L + paramInt2 * 60000L) + String.format("%02d:%02d", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt2) });
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
      a(paramBundle.edit().putBoolean("KEY_HC_ENABLE", true));
    }
    this.IOt = ((CheckBox)findViewById(2131298223));
    this.IOt.setChecked(WXHardCoderJNI.getDebug());
    this.IOr = ((CheckBox)findViewById(2131298229));
    this.IOr.setChecked(WXHardCoderJNI.getEnable());
    this.IOs = ((EditText)findViewById(2131304148));
    this.IOs.setText(WXHardCoderJNI.hcRetryInterval);
    this.IOu = ((CheckBox)findViewById(2131298221));
    this.IOv = ((CheckBox)findViewById(2131298225));
    this.IOv.setChecked(WXHardCoderJNI.hcTimeLimit);
    this.IOw = ((TextView)findViewById(2131297199));
    this.IOx = ((TextView)findViewById(2131299490));
    this.IOw.setText(h(this, WXHardCoderJNI.hcBeginTimeHour, WXHardCoderJNI.hcBeginTimeMin));
    this.IOx.setText(h(this, WXHardCoderJNI.hcEndTimeHour, WXHardCoderJNI.hcEndTimeMin));
    this.IOw.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(39060);
        HardCoderSettingUI.a(HardCoderSettingUI.this, true);
        HardCoderSettingUI.this.showDialog(1);
        AppMethodBeat.o(39060);
      }
    });
    this.IOx.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(39061);
        HardCoderSettingUI.a(HardCoderSettingUI.this, false);
        HardCoderSettingUI.this.showDialog(1);
        AppMethodBeat.o(39061);
      }
    });
    this.IOy = ((CheckBox)findViewById(2131298218));
    this.IOy.setChecked(WXHardCoderJNI.hcBootEnable);
    this.IOz = ((EditText)findViewById(2131298965));
    this.IOz.setText(WXHardCoderJNI.hcBootDelay);
    this.IOA = ((EditText)findViewById(2131305827));
    this.IOA.setText(WXHardCoderJNI.hcBootTimeout);
    this.IOA.setSelection(this.IOA.getText().length());
    this.IOB = ((EditText)findViewById(2131296353));
    this.IOB.setText(WXHardCoderJNI.hcBootAction);
    this.IOC = ((Spinner)findViewById(2131298836));
    this.IOC.setSelection(WXHardCoderJNI.hcBootCPU);
    this.IOD = ((Spinner)findViewById(2131301102));
    this.IOD.setSelection(WXHardCoderJNI.hcBootIO);
    this.IOE = ((CheckBox)findViewById(2131305775));
    this.IOE.setChecked(WXHardCoderJNI.hcBootThr);
    this.IOF = ((CheckBox)findViewById(2131298226));
    this.IOF.setChecked(WXHardCoderJNI.hcEnterChattingEnable);
    this.IOG = ((EditText)findViewById(2131298969));
    this.IOG.setText(WXHardCoderJNI.hcEnterChattingDelay);
    this.IOH = ((EditText)findViewById(2131305831));
    this.IOH.setText(WXHardCoderJNI.hcEnterChattingTimeout);
    this.IOH.setSelection(this.IOH.getText().length());
    this.IOI = ((EditText)findViewById(2131296363));
    this.IOI.setText(WXHardCoderJNI.hcEnterChattingAction);
    this.IOJ = ((Spinner)findViewById(2131298839));
    this.IOJ.setSelection(WXHardCoderJNI.hcEnterChattingCPU);
    this.IOK = ((Spinner)findViewById(2131301105));
    this.IOK.setSelection(WXHardCoderJNI.hcEnterChattingIO);
    this.IOL = ((CheckBox)findViewById(2131305778));
    this.IOL.setChecked(WXHardCoderJNI.hcEnterChattingThr);
    this.IOM = ((CheckBox)findViewById(2131298236));
    this.IOM.setChecked(WXHardCoderJNI.hcQuitChattingEnable);
    this.ION = ((EditText)findViewById(2131298973));
    this.ION.setText(WXHardCoderJNI.hcQuitChattingDelay);
    this.IOO = ((EditText)findViewById(2131305835));
    this.IOO.setText(WXHardCoderJNI.hcQuitChattingTimeout);
    this.IOO.setSelection(this.IOO.getText().length());
    this.IOP = ((EditText)findViewById(2131296378));
    this.IOP.setText(WXHardCoderJNI.hcQuitChattingAction);
    this.IOQ = ((Spinner)findViewById(2131298843));
    this.IOQ.setSelection(WXHardCoderJNI.hcQuitChattingCPU);
    this.IOR = ((Spinner)findViewById(2131301109));
    this.IOR.setSelection(WXHardCoderJNI.hcQuitChattingIO);
    this.IOT = ((CheckBox)findViewById(2131305782));
    this.IOT.setChecked(WXHardCoderJNI.hcQuitChattingThr);
    this.IOU = ((CheckBox)findViewById(2131298239));
    this.IOU.setChecked(WXHardCoderJNI.hcSendMsgEnable);
    this.IOV = ((EditText)findViewById(2131298975));
    this.IOV.setText(WXHardCoderJNI.hcSendMsgDelay);
    this.IOW = ((EditText)findViewById(2131305837));
    this.IOW.setText(WXHardCoderJNI.hcSendMsgTimeout);
    this.IOW.setSelection(this.IOW.getText().length());
    this.IOX = ((EditText)findViewById(2131296381));
    this.IOX.setText(WXHardCoderJNI.hcSendMsgAction);
    this.IOY = ((Spinner)findViewById(2131298845));
    this.IOY.setSelection(WXHardCoderJNI.hcSendMsgCPU);
    this.IOZ = ((Spinner)findViewById(2131301111));
    this.IOZ.setSelection(WXHardCoderJNI.hcSendMsgIO);
    this.IPa = ((CheckBox)findViewById(2131305784));
    this.IPa.setChecked(WXHardCoderJNI.hcSendMsgThr);
    this.IPb = ((CheckBox)findViewById(2131298240));
    this.IPb.setChecked(WXHardCoderJNI.hcSendPicMsgEnable);
    this.IPc = ((EditText)findViewById(2131298976));
    this.IPc.setText(WXHardCoderJNI.hcSendPicMsgDelay);
    this.IPd = ((EditText)findViewById(2131305838));
    this.IPd.setText(WXHardCoderJNI.hcSendPicMsgTimeout);
    this.IPd.setSelection(this.IPd.getText().length());
    this.IPe = ((EditText)findViewById(2131296382));
    this.IPe.setText(WXHardCoderJNI.hcSendPicMsgAction);
    this.IPf = ((Spinner)findViewById(2131298846));
    this.IPf.setSelection(WXHardCoderJNI.hcSendPicMsgCPU);
    this.IPg = ((Spinner)findViewById(2131301112));
    this.IPg.setSelection(WXHardCoderJNI.hcSendPicMsgIO);
    this.IPh = ((CheckBox)findViewById(2131305785));
    this.IPh.setChecked(WXHardCoderJNI.hcSendPicMsgThr);
    this.IPi = ((CheckBox)findViewById(2131298237));
    this.IPi.setChecked(WXHardCoderJNI.hcReceiveMsgEnable);
    this.IPj = ((EditText)findViewById(2131298974));
    this.IPj.setText(WXHardCoderJNI.hcReceiveMsgDelay);
    this.IPk = ((EditText)findViewById(2131305836));
    this.IPk.setText(WXHardCoderJNI.hcReceiveMsgTimeout);
    this.IPk.setSelection(this.IPk.getText().length());
    this.IPl = ((EditText)findViewById(2131296379));
    this.IPl.setText(WXHardCoderJNI.hcReceiveMsgAction);
    this.IPm = ((Spinner)findViewById(2131298844));
    this.IPm.setSelection(WXHardCoderJNI.hcReceiveMsgCPU);
    this.IPn = ((Spinner)findViewById(2131301110));
    this.IPn.setSelection(WXHardCoderJNI.hcReceiveMsgIO);
    this.IPo = ((CheckBox)findViewById(2131305783));
    this.IPo.setChecked(WXHardCoderJNI.hcReceiveMsgThr);
    this.IPp = ((CheckBox)findViewById(2131298253));
    this.IPp.setChecked(WXHardCoderJNI.hcUpdateChatroomEnable);
    this.IPq = ((EditText)findViewById(2131298980));
    this.IPq.setText(WXHardCoderJNI.hcUpdateChatroomDelay);
    this.IPr = ((EditText)findViewById(2131305842));
    this.IPr.setText(WXHardCoderJNI.hcUpdateChatroomTimeout);
    this.IPr.setSelection(this.IPr.getText().length());
    this.IPs = ((EditText)findViewById(2131296392));
    this.IPs.setText(WXHardCoderJNI.hcUpdateChatroomAction);
    this.IPt = ((Spinner)findViewById(2131298850));
    this.IPt.setSelection(WXHardCoderJNI.hcUpdateChatroomCPU);
    this.IPu = ((Spinner)findViewById(2131301116));
    this.IPu.setSelection(WXHardCoderJNI.hcUpdateChatroomIO);
    this.IPv = ((CheckBox)findViewById(2131305789));
    this.IPv.setChecked(WXHardCoderJNI.hcUpdateChatroomThr);
    this.IPw = ((EditText)findViewById(2131306202));
    this.IPw.setText(WXHardCoderJNI.hcUpdateChatroomMemberCount);
    this.IPx = ((CheckBox)findViewById(2131298222));
    this.IPx.setChecked(WXHardCoderJNI.hcDBEnable);
    this.IPy = ((EditText)findViewById(2131298966));
    this.IPy.setText(WXHardCoderJNI.hcDBDelayQuery);
    this.IPz = ((EditText)findViewById(2131298967));
    this.IPz.setText(WXHardCoderJNI.hcDBDelayWrite);
    this.IPA = ((EditText)findViewById(2131305828));
    this.IPA.setText(WXHardCoderJNI.hcDBTimeout);
    this.IPB = ((EditText)findViewById(2131305829));
    this.IPB.setText(WXHardCoderJNI.hcDBTimeoutBusy);
    this.IPC = ((EditText)findViewById(2131296358));
    this.IPC.setText(WXHardCoderJNI.hcDBActionQuery);
    this.IPD = ((EditText)findViewById(2131296359));
    this.IPD.setText(WXHardCoderJNI.hcDBActionWrite);
    this.IPE = ((Spinner)findViewById(2131298837));
    this.IPE.setSelection(WXHardCoderJNI.hcDBCPU);
    this.IPF = ((Spinner)findViewById(2131301103));
    this.IPF.setSelection(WXHardCoderJNI.hcDBIO);
    this.IPG = ((CheckBox)findViewById(2131305776));
    this.IPG.setChecked(WXHardCoderJNI.hcDBThr);
    this.IPH = ((CheckBox)findViewById(2131298254));
    this.IPH.setChecked(WXHardCoderJNI.hcEncodeVideoEnable);
    this.IPI = ((EditText)findViewById(2131298981));
    this.IPI.setText(WXHardCoderJNI.hcEncodeVideoDelay);
    this.IPJ = ((EditText)findViewById(2131305843));
    this.IPJ.setText(WXHardCoderJNI.hcEncodeVideoTimeout);
    this.IPK = ((EditText)findViewById(2131296393));
    this.IPK.setText(WXHardCoderJNI.hcEncodeVideoAction);
    this.IPL = ((Spinner)findViewById(2131298851));
    this.IPL.setSelection(WXHardCoderJNI.hcEncodeVideoCPU);
    this.IPM = ((Spinner)findViewById(2131301117));
    this.IPM.setSelection(WXHardCoderJNI.hcEncodeVideoIO);
    this.IPN = ((CheckBox)findViewById(2131305790));
    this.IPN.setChecked(WXHardCoderJNI.hcEncodeVideoThr);
    this.IPO = ((CheckBox)findViewById(2131298224));
    this.IPO.setChecked(WXHardCoderJNI.hcDecodePicEnable);
    this.IPP = ((EditText)findViewById(2131298968));
    this.IPP.setText(WXHardCoderJNI.hcDecodePicDelay);
    this.IPQ = ((EditText)findViewById(2131305830));
    this.IPQ.setText(WXHardCoderJNI.hcDecodePicTimeout);
    this.IPR = ((EditText)findViewById(2131296360));
    this.IPR.setText(WXHardCoderJNI.hcDecodePicAction);
    this.IPS = ((Spinner)findViewById(2131298838));
    this.IPS.setSelection(WXHardCoderJNI.hcDecodePicCPU);
    this.IPT = ((Spinner)findViewById(2131301104));
    this.IPT.setSelection(WXHardCoderJNI.hcDecodePicIO);
    this.IPU = ((CheckBox)findViewById(2131305777));
    this.IPU.setChecked(WXHardCoderJNI.hcDecodePicThr);
    this.IPV = ((CheckBox)findViewById(2131298227));
    this.IPV.setChecked(WXHardCoderJNI.hcGifEnable);
    this.IPW = ((EditText)findViewById(2131298970));
    this.IPW.setText(WXHardCoderJNI.hcGifDelay);
    this.IPX = ((EditText)findViewById(2131305832));
    this.IPX.setText(WXHardCoderJNI.hcGifTimeout);
    this.IPY = ((EditText)findViewById(2131296364));
    this.IPY.setText(WXHardCoderJNI.hcGifAction);
    this.IPZ = ((Spinner)findViewById(2131298840));
    this.IPZ.setSelection(WXHardCoderJNI.hcGifCPU);
    this.IQa = ((Spinner)findViewById(2131301106));
    this.IQa.setSelection(WXHardCoderJNI.hcGifIO);
    this.IQb = ((CheckBox)findViewById(2131305779));
    this.IQb.setChecked(WXHardCoderJNI.hcGifThr);
    this.IQc = ((CheckBox)findViewById(2131298228));
    this.IQc.setChecked(WXHardCoderJNI.hcGifFrameEnable);
    this.IQd = ((EditText)findViewById(2131298971));
    this.IQd.setText(WXHardCoderJNI.hcGifFrameDelay);
    this.IQe = ((EditText)findViewById(2131305833));
    this.IQe.setText(WXHardCoderJNI.hcGifFrameTimeout);
    this.IQf = ((EditText)findViewById(2131296365));
    this.IQf.setText(WXHardCoderJNI.hcGifFrameAction);
    this.IQg = ((Spinner)findViewById(2131298841));
    this.IQg.setSelection(WXHardCoderJNI.hcGifFrameCPU);
    this.IQh = ((Spinner)findViewById(2131301107));
    this.IQh.setSelection(WXHardCoderJNI.hcGifFrameIO);
    this.IQi = ((CheckBox)findViewById(2131305780));
    this.IQi.setChecked(WXHardCoderJNI.hcGifFrameThr);
    this.IQj = ((CheckBox)findViewById(2131298244));
    this.IQj.setChecked(WXHardCoderJNI.hcSNSScrollEnable);
    this.IQk = ((EditText)findViewById(2131298978));
    this.IQk.setText(WXHardCoderJNI.hcSNSScrollDelay);
    this.IQl = ((EditText)findViewById(2131305840));
    this.IQl.setText(WXHardCoderJNI.hcSNSScrollTimeout);
    this.IQm = ((EditText)findViewById(2131296385));
    this.IQm.setText(WXHardCoderJNI.hcSNSScrollAction);
    this.IQn = ((Spinner)findViewById(2131298848));
    this.IQn.setSelection(WXHardCoderJNI.hcSNSScrollCPU);
    this.IQo = ((Spinner)findViewById(2131301114));
    this.IQo.setSelection(WXHardCoderJNI.hcSNSScrollIO);
    this.IQp = ((CheckBox)findViewById(2131305787));
    this.IQp.setChecked(WXHardCoderJNI.hcSNSScrollThr);
    this.IQq = ((CheckBox)findViewById(2131298245));
    this.IQq.setChecked(WXHardCoderJNI.hcSNSUserScrollEnable);
    this.IQr = ((EditText)findViewById(2131298979));
    this.IQr.setText(WXHardCoderJNI.hcSNSUserScrollDelay);
    this.IQs = ((EditText)findViewById(2131305841));
    this.IQs.setText(WXHardCoderJNI.hcSNSUserScrollTimeout);
    this.IQt = ((EditText)findViewById(2131296386));
    this.IQt.setText(WXHardCoderJNI.hcSNSUserScrollAction);
    this.IQu = ((Spinner)findViewById(2131298849));
    this.IQu.setSelection(WXHardCoderJNI.hcSNSUserScrollCPU);
    this.IQv = ((Spinner)findViewById(2131301115));
    this.IQv.setSelection(WXHardCoderJNI.hcSNSUserScrollIO);
    this.IQw = ((CheckBox)findViewById(2131305788));
    this.IQw.setChecked(WXHardCoderJNI.hcSNSUserScrollThr);
    this.IQx = ((CheckBox)findViewById(2131298243));
    this.IQx.setChecked(WXHardCoderJNI.hcSNSMsgScrollEnable);
    this.IQy = ((EditText)findViewById(2131298977));
    this.IQy.setText(WXHardCoderJNI.hcSNSMsgScrollDelay);
    this.IQz = ((EditText)findViewById(2131305839));
    this.IQz.setText(WXHardCoderJNI.hcSNSMsgScrollTimeout);
    this.IQA = ((EditText)findViewById(2131296384));
    this.IQA.setText(WXHardCoderJNI.hcSNSMsgScrollAction);
    this.IQB = ((Spinner)findViewById(2131298847));
    this.IQB.setSelection(WXHardCoderJNI.hcSNSMsgScrollCPU);
    this.IQC = ((Spinner)findViewById(2131301113));
    this.IQC.setSelection(WXHardCoderJNI.hcSNSMsgScrollIO);
    this.IQD = ((CheckBox)findViewById(2131305786));
    this.IQD.setChecked(WXHardCoderJNI.hcSNSMsgScrollThr);
    this.IQE = ((CheckBox)findViewById(2131298231));
    this.IQE.setChecked(WXHardCoderJNI.hcMediaGalleryScrollEnable);
    this.IQF = ((EditText)findViewById(2131298972));
    this.IQF.setText(WXHardCoderJNI.hcMediaGalleryScrollDelay);
    this.IQG = ((EditText)findViewById(2131305834));
    this.IQG.setText(WXHardCoderJNI.hcMediaGalleryScrollTimeout);
    this.IQH = ((EditText)findViewById(2131296368));
    this.IQH.setText(WXHardCoderJNI.hcMediaGalleryScrollAction);
    this.IQI = ((Spinner)findViewById(2131298842));
    this.IQI.setSelection(WXHardCoderJNI.hcMediaGalleryScrollCPU);
    this.IQJ = ((Spinner)findViewById(2131301108));
    this.IQJ.setSelection(WXHardCoderJNI.hcMediaGalleryScrollIO);
    this.IQK = ((CheckBox)findViewById(2131305781));
    this.IQK.setChecked(WXHardCoderJNI.hcMediaGalleryScrollThr);
    this.IQL = ((CheckBox)findViewById(2131298216));
    this.IQL.setChecked(WXHardCoderJNI.hcAlbumScrollEnable);
    this.IQM = ((EditText)findViewById(2131298963));
    this.IQM.setText(WXHardCoderJNI.hcAlbumScrollDelay);
    this.IQN = ((EditText)findViewById(2131305825));
    this.IQN.setText(WXHardCoderJNI.hcAlbumScrollTimeout);
    this.IQO = ((EditText)findViewById(2131296342));
    this.IQO.setText(WXHardCoderJNI.hcAlbumScrollAction);
    this.IQP = ((Spinner)findViewById(2131298834));
    this.IQP.setSelection(WXHardCoderJNI.hcAlbumScrollCPU);
    this.IQQ = ((Spinner)findViewById(2131301100));
    this.IQQ.setSelection(WXHardCoderJNI.hcAlbumScrollIO);
    this.IQR = ((CheckBox)findViewById(2131305773));
    this.IQR.setChecked(WXHardCoderJNI.hcAlbumScrollThr);
    this.IQS = ((CheckBox)findViewById(2131298217));
    this.IQS.setChecked(WXHardCoderJNI.hcBizEnable);
    this.IQT = ((EditText)findViewById(2131298964));
    this.IQT.setText(WXHardCoderJNI.hcBizDelay);
    this.IQU = ((EditText)findViewById(2131305826));
    this.IQU.setText(WXHardCoderJNI.hcBizTimeout);
    this.IQV = ((EditText)findViewById(2131296352));
    this.IQV.setText(WXHardCoderJNI.hcBizAction);
    this.IQW = ((Spinner)findViewById(2131298835));
    this.IQW.setSelection(WXHardCoderJNI.hcBizCPU);
    this.IQX = ((Spinner)findViewById(2131301101));
    this.IQX.setSelection(WXHardCoderJNI.hcBizIO);
    this.IQY = ((CheckBox)findViewById(2131305774));
    this.IQY.setChecked(WXHardCoderJNI.hcBizThr);
    this.IOr.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(39062);
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
    if (this.xrz)
    {
      localTimePickerDialog = new TimePickerDialog(getContext(), this.xrA, WXHardCoderJNI.hcBeginTimeHour, WXHardCoderJNI.hcBeginTimeMin, false);
      AppMethodBeat.o(39066);
      return localTimePickerDialog;
    }
    TimePickerDialog localTimePickerDialog = new TimePickerDialog(getContext(), this.xrA, WXHardCoderJNI.hcEndTimeHour, WXHardCoderJNI.hcBeginTimeMin, false);
    AppMethodBeat.o(39066);
    return localTimePickerDialog;
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(39067);
    ac.i("HardCoderSettingUI", "save");
    if ((this.IOr.isChecked()) && (!WXHardCoderJNI.getEnable()))
    {
      WXHardCoderJNI.setHcEnable(this.IOr.isChecked());
      WXHardCoderJNI.initHardCoder(a.cSP(), a.cSP(), null);
    }
    WXHardCoderJNI.setDebug(this.IOt.isChecked());
    WXHardCoderJNI.setHcEnable(this.IOr.isChecked());
    WXHardCoderJNI.hcRetryInterval = bs.getInt(this.IOs.getText().toString(), WXHardCoderJNI.hcRetryInterval);
    if (WXHardCoderJNI.isCheckEnv())
    {
      WXHardCoderJNI.setDebug(WXHardCoderJNI.getDebug());
      WXHardCoderJNI.setHcEnable(WXHardCoderJNI.getEnable());
      WXHardCoderJNI.setRetryConnectInterval(WXHardCoderJNI.hcRetryInterval);
    }
    WXHardCoderJNI.hcTimeLimit = this.IOv.isChecked();
    WXHardCoderJNI.hcBootEnable = this.IOy.isChecked();
    WXHardCoderJNI.hcBootDelay = bs.getInt(this.IOz.getText().toString(), WXHardCoderJNI.hcBootDelay);
    WXHardCoderJNI.hcBootCPU = this.IOC.getSelectedItemPosition();
    WXHardCoderJNI.hcBootIO = this.IOD.getSelectedItemPosition();
    WXHardCoderJNI.hcBootThr = this.IOE.isChecked();
    WXHardCoderJNI.hcBootTimeout = bs.getInt(this.IOA.getText().toString(), WXHardCoderJNI.hcBootTimeout);
    WXHardCoderJNI.hcBootAction = bs.getLong(this.IOB.getText().toString(), WXHardCoderJNI.hcBootAction);
    WXHardCoderJNI.hcEnterChattingEnable = this.IOF.isChecked();
    WXHardCoderJNI.hcEnterChattingDelay = bs.getInt(this.IOG.getText().toString(), WXHardCoderJNI.hcEnterChattingDelay);
    WXHardCoderJNI.hcEnterChattingCPU = this.IOJ.getSelectedItemPosition();
    WXHardCoderJNI.hcEnterChattingIO = this.IOK.getSelectedItemPosition();
    WXHardCoderJNI.hcEnterChattingThr = this.IOL.isChecked();
    WXHardCoderJNI.hcEnterChattingTimeout = bs.getInt(this.IOH.getText().toString(), WXHardCoderJNI.hcEnterChattingTimeout);
    WXHardCoderJNI.hcEnterChattingAction = bs.getLong(this.IOI.getText().toString(), WXHardCoderJNI.hcEnterChattingAction);
    WXHardCoderJNI.hcQuitChattingEnable = this.IOM.isChecked();
    WXHardCoderJNI.hcQuitChattingDelay = bs.getInt(this.ION.getText().toString(), WXHardCoderJNI.hcQuitChattingDelay);
    WXHardCoderJNI.hcQuitChattingCPU = this.IOQ.getSelectedItemPosition();
    WXHardCoderJNI.hcQuitChattingIO = this.IOR.getSelectedItemPosition();
    WXHardCoderJNI.hcQuitChattingThr = this.IOT.isChecked();
    WXHardCoderJNI.hcQuitChattingTimeout = bs.getInt(this.IOO.getText().toString(), WXHardCoderJNI.hcQuitChattingTimeout);
    WXHardCoderJNI.hcQuitChattingAction = bs.getLong(this.IOP.getText().toString(), WXHardCoderJNI.hcQuitChattingAction);
    WXHardCoderJNI.hcSendMsgEnable = this.IOU.isChecked();
    WXHardCoderJNI.hcSendMsgDelay = bs.getInt(this.IOV.getText().toString(), WXHardCoderJNI.hcSendMsgDelay);
    WXHardCoderJNI.hcSendMsgCPU = this.IOY.getSelectedItemPosition();
    WXHardCoderJNI.hcSendMsgIO = this.IOZ.getSelectedItemPosition();
    WXHardCoderJNI.hcSendMsgThr = this.IPa.isChecked();
    WXHardCoderJNI.hcSendMsgTimeout = bs.getInt(this.IOW.getText().toString(), WXHardCoderJNI.hcSendMsgTimeout);
    WXHardCoderJNI.hcSendMsgAction = bs.getLong(this.IOX.getText().toString(), WXHardCoderJNI.hcSendMsgAction);
    WXHardCoderJNI.hcSendPicMsgEnable = this.IPb.isChecked();
    WXHardCoderJNI.hcSendPicMsgDelay = bs.getInt(this.IPc.getText().toString(), WXHardCoderJNI.hcSendPicMsgDelay);
    WXHardCoderJNI.hcSendPicMsgCPU = this.IPf.getSelectedItemPosition();
    WXHardCoderJNI.hcSendPicMsgIO = this.IPg.getSelectedItemPosition();
    WXHardCoderJNI.hcSendPicMsgThr = this.IPh.isChecked();
    WXHardCoderJNI.hcSendPicMsgTimeout = bs.getInt(this.IPd.getText().toString(), WXHardCoderJNI.hcSendPicMsgTimeout);
    WXHardCoderJNI.hcSendPicMsgAction = bs.getLong(this.IPe.getText().toString(), WXHardCoderJNI.hcSendPicMsgAction);
    WXHardCoderJNI.hcReceiveMsgEnable = this.IPi.isChecked();
    WXHardCoderJNI.hcReceiveMsgDelay = bs.getInt(this.IPj.getText().toString(), WXHardCoderJNI.hcReceiveMsgDelay);
    WXHardCoderJNI.hcReceiveMsgCPU = this.IPm.getSelectedItemPosition();
    WXHardCoderJNI.hcReceiveMsgIO = this.IPn.getSelectedItemPosition();
    WXHardCoderJNI.hcReceiveMsgThr = this.IPo.isChecked();
    WXHardCoderJNI.hcReceiveMsgTimeout = bs.getInt(this.IPk.getText().toString(), WXHardCoderJNI.hcReceiveMsgTimeout);
    WXHardCoderJNI.hcReceiveMsgAction = bs.getLong(this.IPl.getText().toString(), WXHardCoderJNI.hcReceiveMsgAction);
    WXHardCoderJNI.hcUpdateChatroomEnable = this.IPp.isChecked();
    WXHardCoderJNI.hcUpdateChatroomDelay = bs.getInt(this.IPq.getText().toString(), WXHardCoderJNI.hcUpdateChatroomDelay);
    WXHardCoderJNI.hcUpdateChatroomCPU = this.IPt.getSelectedItemPosition();
    WXHardCoderJNI.hcUpdateChatroomIO = this.IPu.getSelectedItemPosition();
    WXHardCoderJNI.hcUpdateChatroomThr = this.IPv.isChecked();
    WXHardCoderJNI.hcUpdateChatroomTimeout = bs.getInt(this.IPr.getText().toString(), WXHardCoderJNI.hcUpdateChatroomTimeout);
    WXHardCoderJNI.hcUpdateChatroomAction = bs.getLong(this.IPs.getText().toString(), WXHardCoderJNI.hcUpdateChatroomAction);
    WXHardCoderJNI.hcUpdateChatroomMemberCount = bs.getLong(this.IPw.getText().toString(), WXHardCoderJNI.hcUpdateChatroomMemberCount);
    WXHardCoderJNI.hcDBEnable = this.IPx.isChecked();
    WXHardCoderJNI.hcDBDelayQuery = bs.getInt(this.IPy.getText().toString(), WXHardCoderJNI.hcDBDelayQuery);
    WXHardCoderJNI.hcDBDelayWrite = bs.getInt(this.IPz.getText().toString(), WXHardCoderJNI.hcDBDelayWrite);
    WXHardCoderJNI.hcDBCPU = this.IOC.getSelectedItemPosition();
    WXHardCoderJNI.hcDBIO = this.IOD.getSelectedItemPosition();
    WXHardCoderJNI.hcDBThr = this.IOE.isChecked();
    WXHardCoderJNI.hcDBTimeout = bs.getInt(this.IPA.getText().toString(), WXHardCoderJNI.hcDBTimeout);
    WXHardCoderJNI.hcDBTimeoutBusy = bs.getInt(this.IPB.getText().toString(), WXHardCoderJNI.hcDBTimeoutBusy);
    WXHardCoderJNI.hcDBActionQuery = bs.getLong(this.IPC.getText().toString(), WXHardCoderJNI.hcDBActionQuery);
    WXHardCoderJNI.hcDBActionWrite = bs.getLong(this.IPD.getText().toString(), WXHardCoderJNI.hcDBActionWrite);
    WXHardCoderJNI.hcEncodeVideoEnable = this.IPH.isChecked();
    WXHardCoderJNI.hcEncodeVideoDelay = bs.getInt(this.IPI.getText().toString(), WXHardCoderJNI.hcEncodeVideoDelay);
    WXHardCoderJNI.hcEncodeVideoCPU = this.IPL.getSelectedItemPosition();
    WXHardCoderJNI.hcEncodeVideoIO = this.IPM.getSelectedItemPosition();
    WXHardCoderJNI.hcEncodeVideoThr = this.IPN.isChecked();
    WXHardCoderJNI.hcEncodeVideoTimeout = bs.getInt(this.IPJ.getText().toString(), WXHardCoderJNI.hcEncodeVideoTimeout);
    WXHardCoderJNI.hcEncodeVideoAction = bs.getLong(this.IPK.getText().toString(), WXHardCoderJNI.hcEncodeVideoAction);
    WXHardCoderJNI.hcDecodePicEnable = this.IPO.isChecked();
    WXHardCoderJNI.hcDecodePicDelay = bs.getInt(this.IPP.getText().toString(), WXHardCoderJNI.hcDecodePicDelay);
    WXHardCoderJNI.hcDecodePicCPU = this.IPS.getSelectedItemPosition();
    WXHardCoderJNI.hcDecodePicIO = this.IPT.getSelectedItemPosition();
    WXHardCoderJNI.hcDecodePicThr = this.IPU.isChecked();
    WXHardCoderJNI.hcDecodePicTimeout = bs.getInt(this.IPQ.getText().toString(), WXHardCoderJNI.hcDecodePicTimeout);
    WXHardCoderJNI.hcDecodePicAction = bs.getLong(this.IPR.getText().toString(), WXHardCoderJNI.hcDecodePicAction);
    WXHardCoderJNI.hcGifEnable = this.IPV.isChecked();
    WXHardCoderJNI.hcGifDelay = bs.getInt(this.IPW.getText().toString(), WXHardCoderJNI.hcGifDelay);
    WXHardCoderJNI.hcGifCPU = this.IPZ.getSelectedItemPosition();
    WXHardCoderJNI.hcGifIO = this.IQa.getSelectedItemPosition();
    WXHardCoderJNI.hcGifThr = this.IQb.isChecked();
    WXHardCoderJNI.hcGifTimeout = bs.getInt(this.IPX.getText().toString(), WXHardCoderJNI.hcGifTimeout);
    WXHardCoderJNI.hcGifAction = bs.getLong(this.IPY.getText().toString(), WXHardCoderJNI.hcGifAction);
    WXHardCoderJNI.hcGifFrameEnable = this.IQc.isChecked();
    WXHardCoderJNI.hcGifFrameDelay = bs.getInt(this.IQd.getText().toString(), WXHardCoderJNI.hcGifFrameDelay);
    WXHardCoderJNI.hcGifFrameCPU = this.IQg.getSelectedItemPosition();
    WXHardCoderJNI.hcGifFrameIO = this.IQh.getSelectedItemPosition();
    WXHardCoderJNI.hcGifFrameThr = this.IQi.isChecked();
    WXHardCoderJNI.hcGifFrameTimeout = bs.getInt(this.IQe.getText().toString(), WXHardCoderJNI.hcGifFrameTimeout);
    WXHardCoderJNI.hcGifFrameAction = bs.getLong(this.IQf.getText().toString(), WXHardCoderJNI.hcGifFrameAction);
    WXHardCoderJNI.hcSNSScrollEnable = this.IQj.isChecked();
    WXHardCoderJNI.hcSNSScrollDelay = bs.getInt(this.IQk.getText().toString(), WXHardCoderJNI.hcSNSScrollDelay);
    WXHardCoderJNI.hcSNSScrollCPU = this.IQn.getSelectedItemPosition();
    WXHardCoderJNI.hcSNSScrollIO = this.IQo.getSelectedItemPosition();
    WXHardCoderJNI.hcSNSScrollThr = this.IQp.isChecked();
    WXHardCoderJNI.hcSNSScrollTimeout = bs.getInt(this.IQl.getText().toString(), WXHardCoderJNI.hcSNSScrollTimeout);
    WXHardCoderJNI.hcSNSScrollAction = bs.getLong(this.IQm.getText().toString(), WXHardCoderJNI.hcSNSScrollAction);
    WXHardCoderJNI.hcSNSUserScrollEnable = this.IQq.isChecked();
    WXHardCoderJNI.hcSNSUserScrollDelay = bs.getInt(this.IQr.getText().toString(), WXHardCoderJNI.hcSNSUserScrollDelay);
    WXHardCoderJNI.hcSNSUserScrollCPU = this.IQu.getSelectedItemPosition();
    WXHardCoderJNI.hcSNSUserScrollIO = this.IQv.getSelectedItemPosition();
    WXHardCoderJNI.hcSNSUserScrollThr = this.IQw.isChecked();
    WXHardCoderJNI.hcSNSUserScrollTimeout = bs.getInt(this.IQs.getText().toString(), WXHardCoderJNI.hcSNSUserScrollTimeout);
    WXHardCoderJNI.hcSNSUserScrollAction = bs.getLong(this.IQt.getText().toString(), WXHardCoderJNI.hcSNSUserScrollAction);
    WXHardCoderJNI.hcSNSMsgScrollEnable = this.IQx.isChecked();
    WXHardCoderJNI.hcSNSMsgScrollDelay = bs.getInt(this.IQy.getText().toString(), WXHardCoderJNI.hcSNSMsgScrollDelay);
    WXHardCoderJNI.hcSNSMsgScrollCPU = this.IQB.getSelectedItemPosition();
    WXHardCoderJNI.hcSNSMsgScrollIO = this.IQC.getSelectedItemPosition();
    WXHardCoderJNI.hcSNSMsgScrollThr = this.IQD.isChecked();
    WXHardCoderJNI.hcSNSMsgScrollTimeout = bs.getInt(this.IQz.getText().toString(), WXHardCoderJNI.hcSNSMsgScrollTimeout);
    WXHardCoderJNI.hcSNSMsgScrollAction = bs.getLong(this.IQA.getText().toString(), WXHardCoderJNI.hcSNSMsgScrollAction);
    WXHardCoderJNI.hcMediaGalleryScrollEnable = this.IQE.isChecked();
    WXHardCoderJNI.hcMediaGalleryScrollDelay = bs.getInt(this.IQF.getText().toString(), WXHardCoderJNI.hcMediaGalleryScrollDelay);
    WXHardCoderJNI.hcMediaGalleryScrollCPU = this.IQI.getSelectedItemPosition();
    WXHardCoderJNI.hcMediaGalleryScrollIO = this.IQJ.getSelectedItemPosition();
    WXHardCoderJNI.hcMediaGalleryScrollThr = this.IQK.isChecked();
    WXHardCoderJNI.hcMediaGalleryScrollTimeout = bs.getInt(this.IQG.getText().toString(), WXHardCoderJNI.hcMediaGalleryScrollTimeout);
    WXHardCoderJNI.hcMediaGalleryScrollAction = bs.getLong(this.IQH.getText().toString(), WXHardCoderJNI.hcMediaGalleryScrollAction);
    WXHardCoderJNI.hcAlbumScrollEnable = this.IQL.isChecked();
    WXHardCoderJNI.hcAlbumScrollDelay = bs.getInt(this.IQM.getText().toString(), WXHardCoderJNI.hcAlbumScrollDelay);
    WXHardCoderJNI.hcAlbumScrollCPU = this.IQP.getSelectedItemPosition();
    WXHardCoderJNI.hcAlbumScrollIO = this.IQQ.getSelectedItemPosition();
    WXHardCoderJNI.hcAlbumScrollThr = this.IQR.isChecked();
    WXHardCoderJNI.hcAlbumScrollTimeout = bs.getInt(this.IQN.getText().toString(), WXHardCoderJNI.hcAlbumScrollTimeout);
    WXHardCoderJNI.hcAlbumScrollAction = bs.getLong(this.IQO.getText().toString(), WXHardCoderJNI.hcAlbumScrollAction);
    WXHardCoderJNI.hcBizEnable = this.IQS.isChecked();
    WXHardCoderJNI.hcBizDelay = bs.getInt(this.IQT.getText().toString(), WXHardCoderJNI.hcBizDelay);
    WXHardCoderJNI.hcBizCPU = this.IQW.getSelectedItemPosition();
    WXHardCoderJNI.hcBizIO = this.IQX.getSelectedItemPosition();
    WXHardCoderJNI.hcBizThr = this.IQY.isChecked();
    WXHardCoderJNI.hcBizTimeout = bs.getInt(this.IQU.getText().toString(), WXHardCoderJNI.hcBizTimeout);
    WXHardCoderJNI.hcBizAction = bs.getLong(this.IQV.getText().toString(), WXHardCoderJNI.hcBizAction);
    a(getContext().getSharedPreferences("hardcoder_setting", 0).edit());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.tools.HardCoderSettingUI
 * JD-Core Version:    0.7.0.1
 */