package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class ald
  extends esc
{
  public int Njs;
  public long Njv;
  public gol NkQ;
  public String YHk;
  public int YTh;
  public int YWB;
  public int YYs;
  public int Zsp;
  public int oOu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(148653);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.NkQ == null)
      {
        paramVarArgs = new b("Not all required fields were included: Data");
        AppMethodBeat.o(148653);
        throw paramVarArgs;
      }
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(148653);
        throw paramVarArgs;
      }
      paramVarArgs.bS(1, this.Njs);
      paramVarArgs.bS(2, this.YYs);
      paramVarArgs.bS(3, this.YTh);
      paramVarArgs.bS(5, this.YWB);
      if (this.YHk != null) {
        paramVarArgs.g(6, this.YHk);
      }
      if (this.NkQ != null)
      {
        paramVarArgs.qD(7, this.NkQ.computeSize());
        this.NkQ.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(8, this.oOu);
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(9, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(10, this.Zsp);
      paramVarArgs.bv(11, this.Njv);
      AppMethodBeat.o(148653);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.Njs) + 0 + i.a.a.b.b.a.cJ(2, this.YYs) + i.a.a.b.b.a.cJ(3, this.YTh) + i.a.a.b.b.a.cJ(5, this.YWB);
      paramInt = i;
      if (this.YHk != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.YHk);
      }
      i = paramInt;
      if (this.NkQ != null) {
        i = paramInt + i.a.a.a.qC(7, this.NkQ.computeSize());
      }
      i += i.a.a.b.b.a.cJ(8, this.oOu);
      paramInt = i;
      if (this.BaseResponse != null) {
        paramInt = i + i.a.a.a.qC(9, this.BaseResponse.computeSize());
      }
      i = i.a.a.b.b.a.cJ(10, this.Zsp);
      int j = i.a.a.b.b.a.q(11, this.Njv);
      AppMethodBeat.o(148653);
      return paramInt + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      if (this.NkQ == null)
      {
        paramVarArgs = new b("Not all required fields were included: Data");
        AppMethodBeat.o(148653);
        throw paramVarArgs;
      }
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(148653);
        throw paramVarArgs;
      }
      AppMethodBeat.o(148653);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
      ald localald = (ald)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      case 4: 
      default: 
        AppMethodBeat.o(148653);
        return -1;
      case 1: 
        localald.Njs = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(148653);
        return 0;
      case 2: 
        localald.YYs = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(148653);
        return 0;
      case 3: 
        localald.YTh = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(148653);
        return 0;
      case 5: 
        localald.YWB = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(148653);
        return 0;
      case 6: 
        localald.YHk = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(148653);
        return 0;
      case 7: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new gol();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((gol)localObject2).dg((byte[])localObject1);
          }
          localald.NkQ = ((gol)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(148653);
        return 0;
      case 8: 
        localald.oOu = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(148653);
        return 0;
      case 9: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new kd();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((kd)localObject2).parseFrom((byte[])localObject1);
          }
          localald.BaseResponse = ((kd)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(148653);
        return 0;
      case 10: 
        localald.Zsp = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(148653);
        return 0;
      }
      localald.Njv = ((i.a.a.a.a)localObject1).ajGk.aaw();
      AppMethodBeat.o(148653);
      return 0;
    }
    AppMethodBeat.o(148653);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ald
 * JD-Core Version:    0.7.0.1
 */