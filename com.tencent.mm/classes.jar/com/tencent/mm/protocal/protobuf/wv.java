package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class wv
  extends dpc
{
  public String Cog;
  public String Lhl;
  public int Lhm;
  public LinkedList<Integer> Lhn;
  public int Lhq;
  public int dDN;
  public String desc;
  public String qwn;
  
  public wv()
  {
    AppMethodBeat.i(72446);
    this.Lhn = new LinkedList();
    AppMethodBeat.o(72446);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72447);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(72447);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.dDN);
      if (this.qwn != null) {
        paramVarArgs.e(3, this.qwn);
      }
      if (this.Cog != null) {
        paramVarArgs.e(4, this.Cog);
      }
      if (this.Lhl != null) {
        paramVarArgs.e(5, this.Lhl);
      }
      paramVarArgs.aM(6, this.Lhm);
      paramVarArgs.e(7, 2, this.Lhn);
      if (this.desc != null) {
        paramVarArgs.e(8, this.desc);
      }
      paramVarArgs.aM(9, this.Lhq);
      AppMethodBeat.o(72447);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label797;
      }
    }
    label797:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.dDN);
      paramInt = i;
      if (this.qwn != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.qwn);
      }
      i = paramInt;
      if (this.Cog != null) {
        i = paramInt + g.a.a.b.b.a.f(4, this.Cog);
      }
      paramInt = i;
      if (this.Lhl != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.Lhl);
      }
      i = paramInt + g.a.a.b.b.a.bu(6, this.Lhm) + g.a.a.a.c(7, 2, this.Lhn);
      paramInt = i;
      if (this.desc != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.desc);
      }
      i = g.a.a.b.b.a.bu(9, this.Lhq);
      AppMethodBeat.o(72447);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Lhn.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(72447);
          throw paramVarArgs;
        }
        AppMethodBeat.o(72447);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        wv localwv = (wv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72447);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localwv.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72447);
          return 0;
        case 2: 
          localwv.dDN = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(72447);
          return 0;
        case 3: 
          localwv.qwn = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72447);
          return 0;
        case 4: 
          localwv.Cog = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72447);
          return 0;
        case 5: 
          localwv.Lhl = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72447);
          return 0;
        case 6: 
          localwv.Lhm = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(72447);
          return 0;
        case 7: 
          localwv.Lhn.add(Integer.valueOf(((g.a.a.a.a)localObject1).UbS.zi()));
          AppMethodBeat.o(72447);
          return 0;
        case 8: 
          localwv.desc = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72447);
          return 0;
        }
        localwv.Lhq = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(72447);
        return 0;
      }
      AppMethodBeat.o(72447);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.wv
 * JD-Core Version:    0.7.0.1
 */