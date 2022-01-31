package com.tencent.mm.plugin.report.kvdata;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class VoiceInputBehavior
  extends com.tencent.mm.bv.a
{
  public int cancel;
  public int chooseArea;
  public int chooseCantonese;
  public int clear;
  public int click;
  public int fail;
  public int fullScreenVoiceLongClick;
  public long fullScreenVoiceLongClickTime;
  public long initChoose;
  public int longClick;
  public long longClickTime;
  public int send;
  public int setDefaultLanguage;
  public int setSwitchCantonese;
  public int setlanguage;
  public int showInit;
  public int smileIconClick;
  public int textChangeCount;
  public int textChangeReturn;
  public long textChangeTime;
  public int textClick;
  public int voiceIconClick;
  public long voiceInputTime;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(79155);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.cancel);
      paramVarArgs.aO(2, this.send);
      paramVarArgs.aO(3, this.click);
      paramVarArgs.aO(4, this.longClick);
      paramVarArgs.am(5, this.longClickTime);
      paramVarArgs.aO(6, this.textClick);
      paramVarArgs.aO(7, this.textChangeCount);
      paramVarArgs.am(8, this.textChangeTime);
      paramVarArgs.aO(9, this.textChangeReturn);
      paramVarArgs.am(10, this.voiceInputTime);
      paramVarArgs.aO(11, this.fail);
      paramVarArgs.aO(12, this.clear);
      paramVarArgs.aO(13, this.smileIconClick);
      paramVarArgs.aO(14, this.voiceIconClick);
      paramVarArgs.aO(15, this.fullScreenVoiceLongClick);
      paramVarArgs.am(16, this.fullScreenVoiceLongClickTime);
      paramVarArgs.aO(17, this.showInit);
      paramVarArgs.am(18, this.initChoose);
      paramVarArgs.aO(19, this.chooseArea);
      paramVarArgs.aO(20, this.chooseCantonese);
      paramVarArgs.aO(21, this.setlanguage);
      paramVarArgs.aO(22, this.setSwitchCantonese);
      paramVarArgs.aO(23, this.setDefaultLanguage);
      AppMethodBeat.o(79155);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = e.a.a.b.b.a.bl(1, this.cancel);
      int i = e.a.a.b.b.a.bl(2, this.send);
      int j = e.a.a.b.b.a.bl(3, this.click);
      int k = e.a.a.b.b.a.bl(4, this.longClick);
      int m = e.a.a.b.b.a.p(5, this.longClickTime);
      int n = e.a.a.b.b.a.bl(6, this.textClick);
      int i1 = e.a.a.b.b.a.bl(7, this.textChangeCount);
      int i2 = e.a.a.b.b.a.p(8, this.textChangeTime);
      int i3 = e.a.a.b.b.a.bl(9, this.textChangeReturn);
      int i4 = e.a.a.b.b.a.p(10, this.voiceInputTime);
      int i5 = e.a.a.b.b.a.bl(11, this.fail);
      int i6 = e.a.a.b.b.a.bl(12, this.clear);
      int i7 = e.a.a.b.b.a.bl(13, this.smileIconClick);
      int i8 = e.a.a.b.b.a.bl(14, this.voiceIconClick);
      int i9 = e.a.a.b.b.a.bl(15, this.fullScreenVoiceLongClick);
      int i10 = e.a.a.b.b.a.p(16, this.fullScreenVoiceLongClickTime);
      int i11 = e.a.a.b.b.a.bl(17, this.showInit);
      int i12 = e.a.a.b.b.a.p(18, this.initChoose);
      int i13 = e.a.a.b.b.a.bl(19, this.chooseArea);
      int i14 = e.a.a.b.b.a.bl(20, this.chooseCantonese);
      int i15 = e.a.a.b.b.a.bl(21, this.setlanguage);
      int i16 = e.a.a.b.b.a.bl(22, this.setSwitchCantonese);
      int i17 = e.a.a.b.b.a.bl(23, this.setDefaultLanguage);
      AppMethodBeat.o(79155);
      return paramInt + 0 + i + j + k + m + n + i1 + i2 + i3 + i4 + i5 + i6 + i7 + i8 + i9 + i10 + i11 + i12 + i13 + i14 + i15 + i16 + i17;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(79155);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      VoiceInputBehavior localVoiceInputBehavior = (VoiceInputBehavior)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(79155);
        return -1;
      case 1: 
        localVoiceInputBehavior.cancel = locala.CLY.sl();
        AppMethodBeat.o(79155);
        return 0;
      case 2: 
        localVoiceInputBehavior.send = locala.CLY.sl();
        AppMethodBeat.o(79155);
        return 0;
      case 3: 
        localVoiceInputBehavior.click = locala.CLY.sl();
        AppMethodBeat.o(79155);
        return 0;
      case 4: 
        localVoiceInputBehavior.longClick = locala.CLY.sl();
        AppMethodBeat.o(79155);
        return 0;
      case 5: 
        localVoiceInputBehavior.longClickTime = locala.CLY.sm();
        AppMethodBeat.o(79155);
        return 0;
      case 6: 
        localVoiceInputBehavior.textClick = locala.CLY.sl();
        AppMethodBeat.o(79155);
        return 0;
      case 7: 
        localVoiceInputBehavior.textChangeCount = locala.CLY.sl();
        AppMethodBeat.o(79155);
        return 0;
      case 8: 
        localVoiceInputBehavior.textChangeTime = locala.CLY.sm();
        AppMethodBeat.o(79155);
        return 0;
      case 9: 
        localVoiceInputBehavior.textChangeReturn = locala.CLY.sl();
        AppMethodBeat.o(79155);
        return 0;
      case 10: 
        localVoiceInputBehavior.voiceInputTime = locala.CLY.sm();
        AppMethodBeat.o(79155);
        return 0;
      case 11: 
        localVoiceInputBehavior.fail = locala.CLY.sl();
        AppMethodBeat.o(79155);
        return 0;
      case 12: 
        localVoiceInputBehavior.clear = locala.CLY.sl();
        AppMethodBeat.o(79155);
        return 0;
      case 13: 
        localVoiceInputBehavior.smileIconClick = locala.CLY.sl();
        AppMethodBeat.o(79155);
        return 0;
      case 14: 
        localVoiceInputBehavior.voiceIconClick = locala.CLY.sl();
        AppMethodBeat.o(79155);
        return 0;
      case 15: 
        localVoiceInputBehavior.fullScreenVoiceLongClick = locala.CLY.sl();
        AppMethodBeat.o(79155);
        return 0;
      case 16: 
        localVoiceInputBehavior.fullScreenVoiceLongClickTime = locala.CLY.sm();
        AppMethodBeat.o(79155);
        return 0;
      case 17: 
        localVoiceInputBehavior.showInit = locala.CLY.sl();
        AppMethodBeat.o(79155);
        return 0;
      case 18: 
        localVoiceInputBehavior.initChoose = locala.CLY.sm();
        AppMethodBeat.o(79155);
        return 0;
      case 19: 
        localVoiceInputBehavior.chooseArea = locala.CLY.sl();
        AppMethodBeat.o(79155);
        return 0;
      case 20: 
        localVoiceInputBehavior.chooseCantonese = locala.CLY.sl();
        AppMethodBeat.o(79155);
        return 0;
      case 21: 
        localVoiceInputBehavior.setlanguage = locala.CLY.sl();
        AppMethodBeat.o(79155);
        return 0;
      case 22: 
        localVoiceInputBehavior.setSwitchCantonese = locala.CLY.sl();
        AppMethodBeat.o(79155);
        return 0;
      }
      localVoiceInputBehavior.setDefaultLanguage = locala.CLY.sl();
      AppMethodBeat.o(79155);
      return 0;
    }
    AppMethodBeat.o(79155);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.report.kvdata.VoiceInputBehavior
 * JD-Core Version:    0.7.0.1
 */