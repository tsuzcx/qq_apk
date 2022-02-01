package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dnt
  extends cpx
{
  public String Eee;
  public dqp EqI;
  public dns EqK;
  public int Scene;
  public String tlJ;
  public String tlK;
  public SKBuiltinBuffer_t vTK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32487);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.EqI == null)
      {
        paramVarArgs = new b("Not all required fields were included: VoiceAttr");
        AppMethodBeat.o(32487);
        throw paramVarArgs;
      }
      if (this.EqK == null)
      {
        paramVarArgs = new b("Not all required fields were included: UploadCtx");
        AppMethodBeat.o(32487);
        throw paramVarArgs;
      }
      if (this.vTK == null)
      {
        paramVarArgs = new b("Not all required fields were included: Data");
        AppMethodBeat.o(32487);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Eee != null) {
        paramVarArgs.d(2, this.Eee);
      }
      if (this.EqI != null)
      {
        paramVarArgs.ln(3, this.EqI.computeSize());
        this.EqI.writeFields(paramVarArgs);
      }
      if (this.EqK != null)
      {
        paramVarArgs.ln(4, this.EqK.computeSize());
        this.EqK.writeFields(paramVarArgs);
      }
      if (this.vTK != null)
      {
        paramVarArgs.ln(5, this.vTK.computeSize());
        this.vTK.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(6, this.Scene);
      if (this.tlK != null) {
        paramVarArgs.d(7, this.tlK);
      }
      if (this.tlJ != null) {
        paramVarArgs.d(8, this.tlJ);
      }
      AppMethodBeat.o(32487);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1168;
      }
    }
    label1168:
    for (int i = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Eee != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Eee);
      }
      i = paramInt;
      if (this.EqI != null) {
        i = paramInt + f.a.a.a.lm(3, this.EqI.computeSize());
      }
      paramInt = i;
      if (this.EqK != null) {
        paramInt = i + f.a.a.a.lm(4, this.EqK.computeSize());
      }
      i = paramInt;
      if (this.vTK != null) {
        i = paramInt + f.a.a.a.lm(5, this.vTK.computeSize());
      }
      i += f.a.a.b.b.a.bx(6, this.Scene);
      paramInt = i;
      if (this.tlK != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.tlK);
      }
      i = paramInt;
      if (this.tlJ != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.tlJ);
      }
      AppMethodBeat.o(32487);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.EqI == null)
        {
          paramVarArgs = new b("Not all required fields were included: VoiceAttr");
          AppMethodBeat.o(32487);
          throw paramVarArgs;
        }
        if (this.EqK == null)
        {
          paramVarArgs = new b("Not all required fields were included: UploadCtx");
          AppMethodBeat.o(32487);
          throw paramVarArgs;
        }
        if (this.vTK == null)
        {
          paramVarArgs = new b("Not all required fields were included: Data");
          AppMethodBeat.o(32487);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32487);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dnt localdnt = (dnt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32487);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new iv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((iv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdnt.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32487);
          return 0;
        case 2: 
          localdnt.Eee = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32487);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dqp();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dqp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdnt.EqI = ((dqp)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32487);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dns();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dns)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdnt.EqK = ((dns)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32487);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdnt.vTK = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32487);
          return 0;
        case 6: 
          localdnt.Scene = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32487);
          return 0;
        case 7: 
          localdnt.tlK = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32487);
          return 0;
        }
        localdnt.tlJ = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(32487);
        return 0;
      }
      AppMethodBeat.o(32487);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dnt
 * JD-Core Version:    0.7.0.1
 */