package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class dtb
  extends com.tencent.mm.bx.a
{
  public String BJx;
  public int EHK = -1;
  public String EHL;
  public String EHM;
  public String EHN;
  public String EHO;
  public String EHP;
  public int EHQ;
  public String Euj;
  public String cTr;
  public int dkj;
  public int duration = -1;
  public int idx;
  public long mXp;
  public long msgId;
  public int niJ;
  public int scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(188754);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.duration);
      paramVarArgs.aR(2, this.EHK);
      if (this.cTr != null) {
        paramVarArgs.d(3, this.cTr);
      }
      if (this.EHL != null) {
        paramVarArgs.d(4, this.EHL);
      }
      paramVarArgs.aR(5, this.dkj);
      if (this.Euj != null) {
        paramVarArgs.d(6, this.Euj);
      }
      paramVarArgs.aG(7, this.msgId);
      paramVarArgs.aR(8, this.idx);
      if (this.EHM != null) {
        paramVarArgs.d(9, this.EHM);
      }
      if (this.EHN != null) {
        paramVarArgs.d(10, this.EHN);
      }
      if (this.EHO != null) {
        paramVarArgs.d(11, this.EHO);
      }
      if (this.EHP != null) {
        paramVarArgs.d(12, this.EHP);
      }
      paramVarArgs.aG(13, this.mXp);
      paramVarArgs.aR(14, this.scene);
      paramVarArgs.aR(15, this.niJ);
      paramVarArgs.aR(16, this.EHQ);
      if (this.BJx != null) {
        paramVarArgs.d(17, this.BJx);
      }
      AppMethodBeat.o(188754);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bA(1, this.duration) + 0 + f.a.a.b.b.a.bA(2, this.EHK);
      paramInt = i;
      if (this.cTr != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.cTr);
      }
      i = paramInt;
      if (this.EHL != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.EHL);
      }
      i += f.a.a.b.b.a.bA(5, this.dkj);
      paramInt = i;
      if (this.Euj != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Euj);
      }
      i = paramInt + f.a.a.b.b.a.q(7, this.msgId) + f.a.a.b.b.a.bA(8, this.idx);
      paramInt = i;
      if (this.EHM != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.EHM);
      }
      i = paramInt;
      if (this.EHN != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.EHN);
      }
      paramInt = i;
      if (this.EHO != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.EHO);
      }
      i = paramInt;
      if (this.EHP != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.EHP);
      }
      i = i + f.a.a.b.b.a.q(13, this.mXp) + f.a.a.b.b.a.bA(14, this.scene) + f.a.a.b.b.a.bA(15, this.niJ) + f.a.a.b.b.a.bA(16, this.EHQ);
      paramInt = i;
      if (this.BJx != null) {
        paramInt = i + f.a.a.b.b.a.e(17, this.BJx);
      }
      AppMethodBeat.o(188754);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(188754);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dtb localdtb = (dtb)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(188754);
        return -1;
      case 1: 
        localdtb.duration = locala.KhF.xS();
        AppMethodBeat.o(188754);
        return 0;
      case 2: 
        localdtb.EHK = locala.KhF.xS();
        AppMethodBeat.o(188754);
        return 0;
      case 3: 
        localdtb.cTr = locala.KhF.readString();
        AppMethodBeat.o(188754);
        return 0;
      case 4: 
        localdtb.EHL = locala.KhF.readString();
        AppMethodBeat.o(188754);
        return 0;
      case 5: 
        localdtb.dkj = locala.KhF.xS();
        AppMethodBeat.o(188754);
        return 0;
      case 6: 
        localdtb.Euj = locala.KhF.readString();
        AppMethodBeat.o(188754);
        return 0;
      case 7: 
        localdtb.msgId = locala.KhF.xT();
        AppMethodBeat.o(188754);
        return 0;
      case 8: 
        localdtb.idx = locala.KhF.xS();
        AppMethodBeat.o(188754);
        return 0;
      case 9: 
        localdtb.EHM = locala.KhF.readString();
        AppMethodBeat.o(188754);
        return 0;
      case 10: 
        localdtb.EHN = locala.KhF.readString();
        AppMethodBeat.o(188754);
        return 0;
      case 11: 
        localdtb.EHO = locala.KhF.readString();
        AppMethodBeat.o(188754);
        return 0;
      case 12: 
        localdtb.EHP = locala.KhF.readString();
        AppMethodBeat.o(188754);
        return 0;
      case 13: 
        localdtb.mXp = locala.KhF.xT();
        AppMethodBeat.o(188754);
        return 0;
      case 14: 
        localdtb.scene = locala.KhF.xS();
        AppMethodBeat.o(188754);
        return 0;
      case 15: 
        localdtb.niJ = locala.KhF.xS();
        AppMethodBeat.o(188754);
        return 0;
      case 16: 
        localdtb.EHQ = locala.KhF.xS();
        AppMethodBeat.o(188754);
        return 0;
      }
      localdtb.BJx = locala.KhF.readString();
      AppMethodBeat.o(188754);
      return 0;
    }
    AppMethodBeat.o(188754);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dtb
 * JD-Core Version:    0.7.0.1
 */