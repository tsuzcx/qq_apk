package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class alc
  extends erp
{
  public int Njs;
  public long Njv;
  public String YFk;
  public String YHk;
  public int YTh;
  public int YYs;
  public long Zso;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(148652);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.Njs);
      paramVarArgs.bS(2, this.YYs);
      paramVarArgs.bS(3, this.YTh);
      if (this.YHk != null) {
        paramVarArgs.g(4, this.YHk);
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(5, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bv(6, this.Njv);
      if (this.YFk != null) {
        paramVarArgs.g(7, this.YFk);
      }
      paramVarArgs.bv(8, this.Zso);
      AppMethodBeat.o(148652);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.Njs) + 0 + i.a.a.b.b.a.cJ(2, this.YYs) + i.a.a.b.b.a.cJ(3, this.YTh);
      paramInt = i;
      if (this.YHk != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.YHk);
      }
      i = paramInt;
      if (this.BaseRequest != null) {
        i = paramInt + i.a.a.a.qC(5, this.BaseRequest.computeSize());
      }
      i += i.a.a.b.b.a.q(6, this.Njv);
      paramInt = i;
      if (this.YFk != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.YFk);
      }
      i = i.a.a.b.b.a.q(8, this.Zso);
      AppMethodBeat.o(148652);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(148652);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      alc localalc = (alc)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(148652);
        return -1;
      case 1: 
        localalc.Njs = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(148652);
        return 0;
      case 2: 
        localalc.YYs = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(148652);
        return 0;
      case 3: 
        localalc.YTh = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(148652);
        return 0;
      case 4: 
        localalc.YHk = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(148652);
        return 0;
      case 5: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          kc localkc = new kc();
          if ((localObject != null) && (localObject.length > 0)) {
            localkc.parseFrom((byte[])localObject);
          }
          localalc.BaseRequest = localkc;
          paramInt += 1;
        }
        AppMethodBeat.o(148652);
        return 0;
      case 6: 
        localalc.Njv = ((i.a.a.a.a)localObject).ajGk.aaw();
        AppMethodBeat.o(148652);
        return 0;
      case 7: 
        localalc.YFk = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(148652);
        return 0;
      }
      localalc.Zso = ((i.a.a.a.a)localObject).ajGk.aaw();
      AppMethodBeat.o(148652);
      return 0;
    }
    AppMethodBeat.o(148652);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.alc
 * JD-Core Version:    0.7.0.1
 */