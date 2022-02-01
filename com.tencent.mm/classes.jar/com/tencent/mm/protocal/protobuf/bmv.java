package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bmv
  extends com.tencent.mm.bx.a
{
  public String ADt;
  public long Azu;
  public String CIG;
  public int Caa;
  public int DVm;
  public String ESn;
  public int MQS;
  public int MQT;
  public int ZVA;
  public ehe ZVx;
  public String ZVy;
  public ehe ZVz;
  public String hRR;
  public String hzv;
  public int status;
  public String title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258884);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bv(1, this.Azu);
      if (this.ZVx != null)
      {
        paramVarArgs.qD(2, this.ZVx.computeSize());
        this.ZVx.writeFields(paramVarArgs);
      }
      if (this.title != null) {
        paramVarArgs.g(3, this.title);
      }
      if (this.ADt != null) {
        paramVarArgs.g(4, this.ADt);
      }
      paramVarArgs.bS(5, this.DVm);
      paramVarArgs.bS(6, this.MQT);
      paramVarArgs.bS(7, this.MQS);
      paramVarArgs.bS(8, this.Caa);
      if (this.ZVy != null) {
        paramVarArgs.g(9, this.ZVy);
      }
      if (this.ESn != null) {
        paramVarArgs.g(10, this.ESn);
      }
      paramVarArgs.bS(11, this.status);
      if (this.ZVz != null)
      {
        paramVarArgs.qD(12, this.ZVz.computeSize());
        this.ZVz.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(13, this.ZVA);
      if (this.hRR != null) {
        paramVarArgs.g(14, this.hRR);
      }
      if (this.hzv != null) {
        paramVarArgs.g(15, this.hzv);
      }
      if (this.CIG != null) {
        paramVarArgs.g(16, this.CIG);
      }
      AppMethodBeat.o(258884);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.q(1, this.Azu) + 0;
      paramInt = i;
      if (this.ZVx != null) {
        paramInt = i + i.a.a.a.qC(2, this.ZVx.computeSize());
      }
      i = paramInt;
      if (this.title != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.title);
      }
      paramInt = i;
      if (this.ADt != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.ADt);
      }
      i = paramInt + i.a.a.b.b.a.cJ(5, this.DVm) + i.a.a.b.b.a.cJ(6, this.MQT) + i.a.a.b.b.a.cJ(7, this.MQS) + i.a.a.b.b.a.cJ(8, this.Caa);
      paramInt = i;
      if (this.ZVy != null) {
        paramInt = i + i.a.a.b.b.a.h(9, this.ZVy);
      }
      i = paramInt;
      if (this.ESn != null) {
        i = paramInt + i.a.a.b.b.a.h(10, this.ESn);
      }
      i += i.a.a.b.b.a.cJ(11, this.status);
      paramInt = i;
      if (this.ZVz != null) {
        paramInt = i + i.a.a.a.qC(12, this.ZVz.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(13, this.ZVA);
      paramInt = i;
      if (this.hRR != null) {
        paramInt = i + i.a.a.b.b.a.h(14, this.hRR);
      }
      i = paramInt;
      if (this.hzv != null) {
        i = paramInt + i.a.a.b.b.a.h(15, this.hzv);
      }
      paramInt = i;
      if (this.CIG != null) {
        paramInt = i + i.a.a.b.b.a.h(16, this.CIG);
      }
      AppMethodBeat.o(258884);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(258884);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      bmv localbmv = (bmv)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      ehe localehe;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(258884);
        return -1;
      case 1: 
        localbmv.Azu = ((i.a.a.a.a)localObject).ajGk.aaw();
        AppMethodBeat.o(258884);
        return 0;
      case 2: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          localehe = new ehe();
          if ((localObject != null) && (localObject.length > 0)) {
            localehe.parseFrom((byte[])localObject);
          }
          localbmv.ZVx = localehe;
          paramInt += 1;
        }
        AppMethodBeat.o(258884);
        return 0;
      case 3: 
        localbmv.title = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(258884);
        return 0;
      case 4: 
        localbmv.ADt = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(258884);
        return 0;
      case 5: 
        localbmv.DVm = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(258884);
        return 0;
      case 6: 
        localbmv.MQT = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(258884);
        return 0;
      case 7: 
        localbmv.MQS = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(258884);
        return 0;
      case 8: 
        localbmv.Caa = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(258884);
        return 0;
      case 9: 
        localbmv.ZVy = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(258884);
        return 0;
      case 10: 
        localbmv.ESn = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(258884);
        return 0;
      case 11: 
        localbmv.status = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(258884);
        return 0;
      case 12: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          localehe = new ehe();
          if ((localObject != null) && (localObject.length > 0)) {
            localehe.parseFrom((byte[])localObject);
          }
          localbmv.ZVz = localehe;
          paramInt += 1;
        }
        AppMethodBeat.o(258884);
        return 0;
      case 13: 
        localbmv.ZVA = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(258884);
        return 0;
      case 14: 
        localbmv.hRR = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(258884);
        return 0;
      case 15: 
        localbmv.hzv = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(258884);
        return 0;
      }
      localbmv.CIG = ((i.a.a.a.a)localObject).ajGk.readString();
      AppMethodBeat.o(258884);
      return 0;
    }
    AppMethodBeat.o(258884);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bmv
 * JD-Core Version:    0.7.0.1
 */