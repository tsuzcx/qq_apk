package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class ccb
  extends com.tencent.mm.bw.a
{
  public double Ecf;
  public double Ecg;
  public String Euh;
  public String Eui;
  public String Fqw;
  public String Fqx;
  public String Fqy;
  public String Fqz;
  public String Name;
  public String iJU;
  public String iJV;
  public String vkB;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56257);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Name != null) {
        paramVarArgs.d(1, this.Name);
      }
      if (this.Fqw != null) {
        paramVarArgs.d(2, this.Fqw);
      }
      paramVarArgs.e(3, this.Ecf);
      paramVarArgs.e(4, this.Ecg);
      if (this.Fqx != null) {
        paramVarArgs.d(5, this.Fqx);
      }
      if (this.vkB != null) {
        paramVarArgs.d(6, this.vkB);
      }
      if (this.Fqy != null) {
        paramVarArgs.d(7, this.Fqy);
      }
      if (this.iJU != null) {
        paramVarArgs.d(8, this.iJU);
      }
      if (this.iJV != null) {
        paramVarArgs.d(9, this.iJV);
      }
      if (this.Euh != null) {
        paramVarArgs.d(10, this.Euh);
      }
      if (this.Eui != null) {
        paramVarArgs.d(11, this.Eui);
      }
      if (this.Fqz != null) {
        paramVarArgs.d(12, this.Fqz);
      }
      AppMethodBeat.o(56257);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Name == null) {
        break label860;
      }
    }
    label860:
    for (paramInt = f.a.a.b.b.a.e(1, this.Name) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Fqw != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.Fqw);
      }
      i = i + (f.a.a.b.b.a.fK(3) + 8) + (f.a.a.b.b.a.fK(4) + 8);
      paramInt = i;
      if (this.Fqx != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.Fqx);
      }
      i = paramInt;
      if (this.vkB != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.vkB);
      }
      paramInt = i;
      if (this.Fqy != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.Fqy);
      }
      i = paramInt;
      if (this.iJU != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.iJU);
      }
      paramInt = i;
      if (this.iJV != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.iJV);
      }
      i = paramInt;
      if (this.Euh != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.Euh);
      }
      paramInt = i;
      if (this.Eui != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.Eui);
      }
      i = paramInt;
      if (this.Fqz != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.Fqz);
      }
      AppMethodBeat.o(56257);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(56257);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ccb localccb = (ccb)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(56257);
          return -1;
        case 1: 
          localccb.Name = locala.LVo.readString();
          AppMethodBeat.o(56257);
          return 0;
        case 2: 
          localccb.Fqw = locala.LVo.readString();
          AppMethodBeat.o(56257);
          return 0;
        case 3: 
          localccb.Ecf = Double.longBitsToDouble(locala.LVo.gab());
          AppMethodBeat.o(56257);
          return 0;
        case 4: 
          localccb.Ecg = Double.longBitsToDouble(locala.LVo.gab());
          AppMethodBeat.o(56257);
          return 0;
        case 5: 
          localccb.Fqx = locala.LVo.readString();
          AppMethodBeat.o(56257);
          return 0;
        case 6: 
          localccb.vkB = locala.LVo.readString();
          AppMethodBeat.o(56257);
          return 0;
        case 7: 
          localccb.Fqy = locala.LVo.readString();
          AppMethodBeat.o(56257);
          return 0;
        case 8: 
          localccb.iJU = locala.LVo.readString();
          AppMethodBeat.o(56257);
          return 0;
        case 9: 
          localccb.iJV = locala.LVo.readString();
          AppMethodBeat.o(56257);
          return 0;
        case 10: 
          localccb.Euh = locala.LVo.readString();
          AppMethodBeat.o(56257);
          return 0;
        case 11: 
          localccb.Eui = locala.LVo.readString();
          AppMethodBeat.o(56257);
          return 0;
        }
        localccb.Fqz = locala.LVo.readString();
        AppMethodBeat.o(56257);
        return 0;
      }
      AppMethodBeat.o(56257);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ccb
 * JD-Core Version:    0.7.0.1
 */