package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class dwj
  extends com.tencent.mm.bx.a
{
  public int YFu;
  public com.tencent.mm.bx.b YMq;
  public int YMr;
  public int abcm;
  public String abcn;
  public gol abco;
  public int abcp;
  public int abcq;
  public int qvo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32359);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.abco == null)
      {
        paramVarArgs = new i.a.a.b("Not all required fields were included: ClientKey");
        AppMethodBeat.o(32359);
        throw paramVarArgs;
      }
      paramVarArgs.bS(1, this.abcm);
      if (this.YMq != null) {
        paramVarArgs.d(2, this.YMq);
      }
      if (this.abcn != null) {
        paramVarArgs.g(3, this.abcn);
      }
      if (this.abco != null)
      {
        paramVarArgs.qD(4, this.abco.computeSize());
        this.abco.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(5, this.abcp);
      paramVarArgs.bS(6, this.abcq);
      paramVarArgs.bS(7, this.YMr);
      paramVarArgs.bS(8, this.qvo);
      paramVarArgs.bS(9, this.YFu);
      AppMethodBeat.o(32359);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.abcm) + 0;
      paramInt = i;
      if (this.YMq != null) {
        paramInt = i + i.a.a.b.b.a.c(2, this.YMq);
      }
      i = paramInt;
      if (this.abcn != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.abcn);
      }
      paramInt = i;
      if (this.abco != null) {
        paramInt = i + i.a.a.a.qC(4, this.abco.computeSize());
      }
      i = i.a.a.b.b.a.cJ(5, this.abcp);
      int j = i.a.a.b.b.a.cJ(6, this.abcq);
      int k = i.a.a.b.b.a.cJ(7, this.YMr);
      int m = i.a.a.b.b.a.cJ(8, this.qvo);
      int n = i.a.a.b.b.a.cJ(9, this.YFu);
      AppMethodBeat.o(32359);
      return paramInt + i + j + k + m + n;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      if (this.abco == null)
      {
        paramVarArgs = new i.a.a.b("Not all required fields were included: ClientKey");
        AppMethodBeat.o(32359);
        throw paramVarArgs;
      }
      AppMethodBeat.o(32359);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      dwj localdwj = (dwj)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(32359);
        return -1;
      case 1: 
        localdwj.abcm = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(32359);
        return 0;
      case 2: 
        localdwj.YMq = ((i.a.a.a.a)localObject).ajGk.kFX();
        AppMethodBeat.o(32359);
        return 0;
      case 3: 
        localdwj.abcn = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(32359);
        return 0;
      case 4: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          gol localgol = new gol();
          if ((localObject != null) && (localObject.length > 0)) {
            localgol.dg((byte[])localObject);
          }
          localdwj.abco = localgol;
          paramInt += 1;
        }
        AppMethodBeat.o(32359);
        return 0;
      case 5: 
        localdwj.abcp = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(32359);
        return 0;
      case 6: 
        localdwj.abcq = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(32359);
        return 0;
      case 7: 
        localdwj.YMr = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(32359);
        return 0;
      case 8: 
        localdwj.qvo = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(32359);
        return 0;
      }
      localdwj.YFu = ((i.a.a.a.a)localObject).ajGk.aar();
      AppMethodBeat.o(32359);
      return 0;
    }
    AppMethodBeat.o(32359);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dwj
 * JD-Core Version:    0.7.0.1
 */