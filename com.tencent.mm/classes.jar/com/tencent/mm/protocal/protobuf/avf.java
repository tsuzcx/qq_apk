package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class avf
  extends dop
{
  public String LAt;
  public aov LBM;
  public b LFp;
  public long hyH;
  public long object_id;
  public String object_nonce_id;
  public int scene;
  public aut uio;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209498);
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
      if (this.LFp != null) {
        paramVarArgs.c(3, this.LFp);
      }
      if (this.uio != null)
      {
        paramVarArgs.ni(4, this.uio.computeSize());
        this.uio.writeFields(paramVarArgs);
      }
      paramVarArgs.bb(5, this.hyH);
      paramVarArgs.bb(6, this.object_id);
      if (this.object_nonce_id != null) {
        paramVarArgs.e(7, this.object_nonce_id);
      }
      paramVarArgs.aM(8, this.scene);
      if (this.LAt != null) {
        paramVarArgs.e(9, this.LAt);
      }
      AppMethodBeat.o(209498);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label938;
      }
    }
    label938:
    for (int i = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.LBM != null) {
        paramInt = i + g.a.a.a.nh(2, this.LBM.computeSize());
      }
      i = paramInt;
      if (this.LFp != null) {
        i = paramInt + g.a.a.b.b.a.b(3, this.LFp);
      }
      paramInt = i;
      if (this.uio != null) {
        paramInt = i + g.a.a.a.nh(4, this.uio.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.r(5, this.hyH) + g.a.a.b.b.a.r(6, this.object_id);
      paramInt = i;
      if (this.object_nonce_id != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.object_nonce_id);
      }
      i = paramInt + g.a.a.b.b.a.bu(8, this.scene);
      paramInt = i;
      if (this.LAt != null) {
        paramInt = i + g.a.a.b.b.a.f(9, this.LAt);
      }
      AppMethodBeat.o(209498);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(209498);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        avf localavf = (avf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(209498);
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
            localavf.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209498);
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
            localavf.LBM = ((aov)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209498);
          return 0;
        case 3: 
          localavf.LFp = ((g.a.a.a.a)localObject1).UbS.hPo();
          AppMethodBeat.o(209498);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aut();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aut)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localavf.uio = ((aut)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209498);
          return 0;
        case 5: 
          localavf.hyH = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(209498);
          return 0;
        case 6: 
          localavf.object_id = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(209498);
          return 0;
        case 7: 
          localavf.object_nonce_id = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(209498);
          return 0;
        case 8: 
          localavf.scene = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(209498);
          return 0;
        }
        localavf.LAt = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(209498);
        return 0;
      }
      AppMethodBeat.o(209498);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.avf
 * JD-Core Version:    0.7.0.1
 */