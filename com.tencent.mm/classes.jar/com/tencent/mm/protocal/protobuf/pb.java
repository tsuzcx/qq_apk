package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class pb
  extends com.tencent.mm.bx.a
{
  public int HTK;
  public int YHV;
  public int YSc;
  public int YSd;
  public int YSe;
  public int YSf;
  public aer YSg;
  public int YSh;
  public int YSi;
  public int YSj = 0;
  public int YSk;
  public String content;
  public String nQG;
  public String openid;
  public String xkX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(103203);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.YSc);
      paramVarArgs.bS(2, this.YHV);
      if (this.openid != null) {
        paramVarArgs.g(3, this.openid);
      }
      if (this.xkX != null) {
        paramVarArgs.g(4, this.xkX);
      }
      if (this.nQG != null) {
        paramVarArgs.g(5, this.nQG);
      }
      if (this.content != null) {
        paramVarArgs.g(6, this.content);
      }
      paramVarArgs.bS(7, this.HTK);
      paramVarArgs.bS(8, this.YSd);
      paramVarArgs.bS(9, this.YSe);
      paramVarArgs.bS(10, this.YSf);
      if (this.YSg != null)
      {
        paramVarArgs.qD(11, this.YSg.computeSize());
        this.YSg.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(12, this.YSh);
      paramVarArgs.bS(13, this.YSi);
      paramVarArgs.bS(14, this.YSj);
      paramVarArgs.bS(15, this.YSk);
      AppMethodBeat.o(103203);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.YSc) + 0 + i.a.a.b.b.a.cJ(2, this.YHV);
      paramInt = i;
      if (this.openid != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.openid);
      }
      i = paramInt;
      if (this.xkX != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.xkX);
      }
      paramInt = i;
      if (this.nQG != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.nQG);
      }
      i = paramInt;
      if (this.content != null) {
        i = paramInt + i.a.a.b.b.a.h(6, this.content);
      }
      i = i + i.a.a.b.b.a.cJ(7, this.HTK) + i.a.a.b.b.a.cJ(8, this.YSd) + i.a.a.b.b.a.cJ(9, this.YSe) + i.a.a.b.b.a.cJ(10, this.YSf);
      paramInt = i;
      if (this.YSg != null) {
        paramInt = i + i.a.a.a.qC(11, this.YSg.computeSize());
      }
      i = i.a.a.b.b.a.cJ(12, this.YSh);
      int j = i.a.a.b.b.a.cJ(13, this.YSi);
      int k = i.a.a.b.b.a.cJ(14, this.YSj);
      int m = i.a.a.b.b.a.cJ(15, this.YSk);
      AppMethodBeat.o(103203);
      return paramInt + i + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(103203);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      pb localpb = (pb)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(103203);
        return -1;
      case 1: 
        localpb.YSc = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(103203);
        return 0;
      case 2: 
        localpb.YHV = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(103203);
        return 0;
      case 3: 
        localpb.openid = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(103203);
        return 0;
      case 4: 
        localpb.xkX = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(103203);
        return 0;
      case 5: 
        localpb.nQG = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(103203);
        return 0;
      case 6: 
        localpb.content = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(103203);
        return 0;
      case 7: 
        localpb.HTK = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(103203);
        return 0;
      case 8: 
        localpb.YSd = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(103203);
        return 0;
      case 9: 
        localpb.YSe = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(103203);
        return 0;
      case 10: 
        localpb.YSf = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(103203);
        return 0;
      case 11: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          aer localaer = new aer();
          if ((localObject != null) && (localObject.length > 0)) {
            localaer.parseFrom((byte[])localObject);
          }
          localpb.YSg = localaer;
          paramInt += 1;
        }
        AppMethodBeat.o(103203);
        return 0;
      case 12: 
        localpb.YSh = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(103203);
        return 0;
      case 13: 
        localpb.YSi = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(103203);
        return 0;
      case 14: 
        localpb.YSj = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(103203);
        return 0;
      }
      localpb.YSk = ((i.a.a.a.a)localObject).ajGk.aar();
      AppMethodBeat.o(103203);
      return 0;
    }
    AppMethodBeat.o(103203);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.pb
 * JD-Core Version:    0.7.0.1
 */