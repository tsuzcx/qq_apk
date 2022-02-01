package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class tq
  extends cqk
{
  public String EmZ;
  public int Ena;
  public LinkedList<Integer> Enb;
  public int Ene;
  public int dae;
  public String desc;
  public String oxf;
  public String wJR;
  
  public tq()
  {
    AppMethodBeat.i(72446);
    this.Enb = new LinkedList();
    AppMethodBeat.o(72446);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72447);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(72447);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.dae);
      if (this.oxf != null) {
        paramVarArgs.d(3, this.oxf);
      }
      if (this.wJR != null) {
        paramVarArgs.d(4, this.wJR);
      }
      if (this.EmZ != null) {
        paramVarArgs.d(5, this.EmZ);
      }
      paramVarArgs.aR(6, this.Ena);
      paramVarArgs.e(7, 2, this.Enb);
      if (this.desc != null) {
        paramVarArgs.d(8, this.desc);
      }
      paramVarArgs.aR(9, this.Ene);
      AppMethodBeat.o(72447);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label797;
      }
    }
    label797:
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.dae);
      paramInt = i;
      if (this.oxf != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.oxf);
      }
      i = paramInt;
      if (this.wJR != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.wJR);
      }
      paramInt = i;
      if (this.EmZ != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.EmZ);
      }
      i = paramInt + f.a.a.b.b.a.bx(6, this.Ena) + f.a.a.a.c(7, 2, this.Enb);
      paramInt = i;
      if (this.desc != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.desc);
      }
      i = f.a.a.b.b.a.bx(9, this.Ene);
      AppMethodBeat.o(72447);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Enb.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cqk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cqk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
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
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        tq localtq = (tq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72447);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localtq.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72447);
          return 0;
        case 2: 
          localtq.dae = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(72447);
          return 0;
        case 3: 
          localtq.oxf = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72447);
          return 0;
        case 4: 
          localtq.wJR = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72447);
          return 0;
        case 5: 
          localtq.EmZ = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72447);
          return 0;
        case 6: 
          localtq.Ena = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(72447);
          return 0;
        case 7: 
          localtq.Enb.add(Integer.valueOf(((f.a.a.a.a)localObject1).LVo.xF()));
          AppMethodBeat.o(72447);
          return 0;
        case 8: 
          localtq.desc = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72447);
          return 0;
        }
        localtq.Ene = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(72447);
        return 0;
      }
      AppMethodBeat.o(72447);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.tq
 * JD-Core Version:    0.7.0.1
 */