package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class aum
  extends dop
{
  public aov LBM;
  public b LFp;
  public int LFq;
  public String LFr;
  public long count;
  public int dYx;
  public long hyH;
  public long object_id;
  public int scene;
  public long seq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209479);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.LBM != null)
      {
        paramVarArgs.ni(2, this.LBM.computeSize());
        this.LBM.writeFields(paramVarArgs);
      }
      paramVarArgs.bb(3, this.hyH);
      paramVarArgs.bb(4, this.count);
      if (this.LFp != null) {
        paramVarArgs.c(5, this.LFp);
      }
      paramVarArgs.bb(6, this.object_id);
      paramVarArgs.bb(7, this.seq);
      paramVarArgs.aM(8, this.LFq);
      if (this.LFr != null) {
        paramVarArgs.e(9, this.LFr);
      }
      paramVarArgs.aM(10, this.scene);
      paramVarArgs.aM(11, this.dYx);
      AppMethodBeat.o(209479);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label902;
      }
    }
    label902:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.LBM != null) {
        i = paramInt + g.a.a.a.nh(2, this.LBM.computeSize());
      }
      i = i + g.a.a.b.b.a.r(3, this.hyH) + g.a.a.b.b.a.r(4, this.count);
      paramInt = i;
      if (this.LFp != null) {
        paramInt = i + g.a.a.b.b.a.b(5, this.LFp);
      }
      i = paramInt + g.a.a.b.b.a.r(6, this.object_id) + g.a.a.b.b.a.r(7, this.seq) + g.a.a.b.b.a.bu(8, this.LFq);
      paramInt = i;
      if (this.LFr != null) {
        paramInt = i + g.a.a.b.b.a.f(9, this.LFr);
      }
      i = g.a.a.b.b.a.bu(10, this.scene);
      int j = g.a.a.b.b.a.bu(11, this.dYx);
      AppMethodBeat.o(209479);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(209479);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        aum localaum = (aum)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(209479);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jr();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jr)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localaum.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209479);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aov();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aov)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localaum.LBM = ((aov)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209479);
          return 0;
        case 3: 
          localaum.hyH = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(209479);
          return 0;
        case 4: 
          localaum.count = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(209479);
          return 0;
        case 5: 
          localaum.LFp = ((g.a.a.a.a)localObject1).UbS.hPo();
          AppMethodBeat.o(209479);
          return 0;
        case 6: 
          localaum.object_id = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(209479);
          return 0;
        case 7: 
          localaum.seq = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(209479);
          return 0;
        case 8: 
          localaum.LFq = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(209479);
          return 0;
        case 9: 
          localaum.LFr = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(209479);
          return 0;
        case 10: 
          localaum.scene = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(209479);
          return 0;
        }
        localaum.dYx = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(209479);
        return 0;
      }
      AppMethodBeat.o(209479);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aum
 * JD-Core Version:    0.7.0.1
 */