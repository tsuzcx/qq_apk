package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class coy
  extends buy
{
  public int Scene;
  public String nul;
  public String num;
  public SKBuiltinBuffer_t pIA;
  public String wAs;
  public crd wLH;
  public cox wLJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28690);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wLH == null)
      {
        paramVarArgs = new b("Not all required fields were included: VoiceAttr");
        AppMethodBeat.o(28690);
        throw paramVarArgs;
      }
      if (this.wLJ == null)
      {
        paramVarArgs = new b("Not all required fields were included: UploadCtx");
        AppMethodBeat.o(28690);
        throw paramVarArgs;
      }
      if (this.pIA == null)
      {
        paramVarArgs = new b("Not all required fields were included: Data");
        AppMethodBeat.o(28690);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.wAs != null) {
        paramVarArgs.e(2, this.wAs);
      }
      if (this.wLH != null)
      {
        paramVarArgs.iQ(3, this.wLH.computeSize());
        this.wLH.writeFields(paramVarArgs);
      }
      if (this.wLJ != null)
      {
        paramVarArgs.iQ(4, this.wLJ.computeSize());
        this.wLJ.writeFields(paramVarArgs);
      }
      if (this.pIA != null)
      {
        paramVarArgs.iQ(5, this.pIA.computeSize());
        this.pIA.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(6, this.Scene);
      if (this.num != null) {
        paramVarArgs.e(7, this.num);
      }
      if (this.nul != null) {
        paramVarArgs.e(8, this.nul);
      }
      AppMethodBeat.o(28690);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1168;
      }
    }
    label1168:
    for (int i = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.wAs != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.wAs);
      }
      i = paramInt;
      if (this.wLH != null) {
        i = paramInt + e.a.a.a.iP(3, this.wLH.computeSize());
      }
      paramInt = i;
      if (this.wLJ != null) {
        paramInt = i + e.a.a.a.iP(4, this.wLJ.computeSize());
      }
      i = paramInt;
      if (this.pIA != null) {
        i = paramInt + e.a.a.a.iP(5, this.pIA.computeSize());
      }
      i += e.a.a.b.b.a.bl(6, this.Scene);
      paramInt = i;
      if (this.num != null) {
        paramInt = i + e.a.a.b.b.a.f(7, this.num);
      }
      i = paramInt;
      if (this.nul != null) {
        i = paramInt + e.a.a.b.b.a.f(8, this.nul);
      }
      AppMethodBeat.o(28690);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.wLH == null)
        {
          paramVarArgs = new b("Not all required fields were included: VoiceAttr");
          AppMethodBeat.o(28690);
          throw paramVarArgs;
        }
        if (this.wLJ == null)
        {
          paramVarArgs = new b("Not all required fields were included: UploadCtx");
          AppMethodBeat.o(28690);
          throw paramVarArgs;
        }
        if (this.pIA == null)
        {
          paramVarArgs = new b("Not all required fields were included: Data");
          AppMethodBeat.o(28690);
          throw paramVarArgs;
        }
        AppMethodBeat.o(28690);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        coy localcoy = (coy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(28690);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new hq();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((hq)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcoy.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28690);
          return 0;
        case 2: 
          localcoy.wAs = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28690);
          return 0;
        case 3: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new crd();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((crd)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcoy.wLH = ((crd)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28690);
          return 0;
        case 4: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cox();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cox)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcoy.wLJ = ((cox)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28690);
          return 0;
        case 5: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcoy.pIA = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28690);
          return 0;
        case 6: 
          localcoy.Scene = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28690);
          return 0;
        case 7: 
          localcoy.num = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28690);
          return 0;
        }
        localcoy.nul = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(28690);
        return 0;
      }
      AppMethodBeat.o(28690);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.coy
 * JD-Core Version:    0.7.0.1
 */