package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dtk
  extends cvc
{
  public String FKD;
  public dwj FXS;
  public dtj FXU;
  public int Scene;
  public String uki;
  public String ukj;
  public SKBuiltinBuffer_t xcN;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32487);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FXS == null)
      {
        paramVarArgs = new b("Not all required fields were included: VoiceAttr");
        AppMethodBeat.o(32487);
        throw paramVarArgs;
      }
      if (this.FXU == null)
      {
        paramVarArgs = new b("Not all required fields were included: UploadCtx");
        AppMethodBeat.o(32487);
        throw paramVarArgs;
      }
      if (this.xcN == null)
      {
        paramVarArgs = new b("Not all required fields were included: Data");
        AppMethodBeat.o(32487);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.FKD != null) {
        paramVarArgs.d(2, this.FKD);
      }
      if (this.FXS != null)
      {
        paramVarArgs.lC(3, this.FXS.computeSize());
        this.FXS.writeFields(paramVarArgs);
      }
      if (this.FXU != null)
      {
        paramVarArgs.lC(4, this.FXU.computeSize());
        this.FXU.writeFields(paramVarArgs);
      }
      if (this.xcN != null)
      {
        paramVarArgs.lC(5, this.xcN.computeSize());
        this.xcN.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(6, this.Scene);
      if (this.ukj != null) {
        paramVarArgs.d(7, this.ukj);
      }
      if (this.uki != null) {
        paramVarArgs.d(8, this.uki);
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
    for (int i = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.FKD != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.FKD);
      }
      i = paramInt;
      if (this.FXS != null) {
        i = paramInt + f.a.a.a.lB(3, this.FXS.computeSize());
      }
      paramInt = i;
      if (this.FXU != null) {
        paramInt = i + f.a.a.a.lB(4, this.FXU.computeSize());
      }
      i = paramInt;
      if (this.xcN != null) {
        i = paramInt + f.a.a.a.lB(5, this.xcN.computeSize());
      }
      i += f.a.a.b.b.a.bz(6, this.Scene);
      paramInt = i;
      if (this.ukj != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.ukj);
      }
      i = paramInt;
      if (this.uki != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.uki);
      }
      AppMethodBeat.o(32487);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.FXS == null)
        {
          paramVarArgs = new b("Not all required fields were included: VoiceAttr");
          AppMethodBeat.o(32487);
          throw paramVarArgs;
        }
        if (this.FXU == null)
        {
          paramVarArgs = new b("Not all required fields were included: UploadCtx");
          AppMethodBeat.o(32487);
          throw paramVarArgs;
        }
        if (this.xcN == null)
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
        dtk localdtk = (dtk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32487);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdtk.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32487);
          return 0;
        case 2: 
          localdtk.FKD = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32487);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dwj();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dwj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdtk.FXS = ((dwj)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32487);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dtj();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dtj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdtk.FXU = ((dtj)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32487);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdtk.xcN = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32487);
          return 0;
        case 6: 
          localdtk.Scene = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32487);
          return 0;
        case 7: 
          localdtk.ukj = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32487);
          return 0;
        }
        localdtk.uki = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(32487);
        return 0;
      }
      AppMethodBeat.o(32487);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dtk
 * JD-Core Version:    0.7.0.1
 */