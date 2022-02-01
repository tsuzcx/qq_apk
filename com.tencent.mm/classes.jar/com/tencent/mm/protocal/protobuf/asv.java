package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class asv
  extends dop
{
  public apc LAv;
  public aov LBM;
  public avk LDR;
  public b LDs;
  public float dTj;
  public float latitude;
  public long object_id;
  public String object_nonce_id;
  public int scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209427);
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
      if (this.LDs != null) {
        paramVarArgs.c(3, this.LDs);
      }
      paramVarArgs.bb(4, this.object_id);
      if (this.object_nonce_id != null) {
        paramVarArgs.e(5, this.object_nonce_id);
      }
      paramVarArgs.E(6, this.dTj);
      paramVarArgs.E(7, this.latitude);
      paramVarArgs.aM(8, this.scene);
      if (this.LAv != null)
      {
        paramVarArgs.ni(9, this.LAv.computeSize());
        this.LAv.writeFields(paramVarArgs);
      }
      if (this.LDR != null)
      {
        paramVarArgs.ni(10, this.LDR.computeSize());
        this.LDR.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(209427);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1076;
      }
    }
    label1076:
    for (int i = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.LBM != null) {
        paramInt = i + g.a.a.a.nh(2, this.LBM.computeSize());
      }
      i = paramInt;
      if (this.LDs != null) {
        i = paramInt + g.a.a.b.b.a.b(3, this.LDs);
      }
      i += g.a.a.b.b.a.r(4, this.object_id);
      paramInt = i;
      if (this.object_nonce_id != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.object_nonce_id);
      }
      i = paramInt + (g.a.a.b.b.a.fS(6) + 4) + (g.a.a.b.b.a.fS(7) + 4) + g.a.a.b.b.a.bu(8, this.scene);
      paramInt = i;
      if (this.LAv != null) {
        paramInt = i + g.a.a.a.nh(9, this.LAv.computeSize());
      }
      i = paramInt;
      if (this.LDR != null) {
        i = paramInt + g.a.a.a.nh(10, this.LDR.computeSize());
      }
      AppMethodBeat.o(209427);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(209427);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        asv localasv = (asv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(209427);
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
            localasv.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209427);
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
            localasv.LBM = ((aov)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209427);
          return 0;
        case 3: 
          localasv.LDs = ((g.a.a.a.a)localObject1).UbS.hPo();
          AppMethodBeat.o(209427);
          return 0;
        case 4: 
          localasv.object_id = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(209427);
          return 0;
        case 5: 
          localasv.object_nonce_id = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(209427);
          return 0;
        case 6: 
          localasv.dTj = Float.intBitsToFloat(((g.a.a.a.a)localObject1).UbS.zm());
          AppMethodBeat.o(209427);
          return 0;
        case 7: 
          localasv.latitude = Float.intBitsToFloat(((g.a.a.a.a)localObject1).UbS.zm());
          AppMethodBeat.o(209427);
          return 0;
        case 8: 
          localasv.scene = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(209427);
          return 0;
        case 9: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new apc();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((apc)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localasv.LAv = ((apc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209427);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new avk();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((avk)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localasv.LDR = ((avk)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(209427);
        return 0;
      }
      AppMethodBeat.o(209427);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.asv
 * JD-Core Version:    0.7.0.1
 */