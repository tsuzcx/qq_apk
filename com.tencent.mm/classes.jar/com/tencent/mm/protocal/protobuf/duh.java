package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class duh
  extends cvw
{
  public String Gdc;
  public dya Gqr;
  public dug Gqt;
  public int Scene;
  public String uvF;
  public String uvG;
  public SKBuiltinBuffer_t xsE;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32487);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Gqr == null)
      {
        paramVarArgs = new b("Not all required fields were included: VoiceAttr");
        AppMethodBeat.o(32487);
        throw paramVarArgs;
      }
      if (this.Gqt == null)
      {
        paramVarArgs = new b("Not all required fields were included: UploadCtx");
        AppMethodBeat.o(32487);
        throw paramVarArgs;
      }
      if (this.xsE == null)
      {
        paramVarArgs = new b("Not all required fields were included: Data");
        AppMethodBeat.o(32487);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Gdc != null) {
        paramVarArgs.d(2, this.Gdc);
      }
      if (this.Gqr != null)
      {
        paramVarArgs.lJ(3, this.Gqr.computeSize());
        this.Gqr.writeFields(paramVarArgs);
      }
      if (this.Gqt != null)
      {
        paramVarArgs.lJ(4, this.Gqt.computeSize());
        this.Gqt.writeFields(paramVarArgs);
      }
      if (this.xsE != null)
      {
        paramVarArgs.lJ(5, this.xsE.computeSize());
        this.xsE.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(6, this.Scene);
      if (this.uvG != null) {
        paramVarArgs.d(7, this.uvG);
      }
      if (this.uvF != null) {
        paramVarArgs.d(8, this.uvF);
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
    for (int i = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Gdc != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Gdc);
      }
      i = paramInt;
      if (this.Gqr != null) {
        i = paramInt + f.a.a.a.lI(3, this.Gqr.computeSize());
      }
      paramInt = i;
      if (this.Gqt != null) {
        paramInt = i + f.a.a.a.lI(4, this.Gqt.computeSize());
      }
      i = paramInt;
      if (this.xsE != null) {
        i = paramInt + f.a.a.a.lI(5, this.xsE.computeSize());
      }
      i += f.a.a.b.b.a.bz(6, this.Scene);
      paramInt = i;
      if (this.uvG != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.uvG);
      }
      i = paramInt;
      if (this.uvF != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.uvF);
      }
      AppMethodBeat.o(32487);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.Gqr == null)
        {
          paramVarArgs = new b("Not all required fields were included: VoiceAttr");
          AppMethodBeat.o(32487);
          throw paramVarArgs;
        }
        if (this.Gqt == null)
        {
          paramVarArgs = new b("Not all required fields were included: UploadCtx");
          AppMethodBeat.o(32487);
          throw paramVarArgs;
        }
        if (this.xsE == null)
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
        duh localduh = (duh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32487);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localduh.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32487);
          return 0;
        case 2: 
          localduh.Gdc = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32487);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dya();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dya)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localduh.Gqr = ((dya)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32487);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dug();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dug)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localduh.Gqt = ((dug)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32487);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localduh.xsE = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32487);
          return 0;
        case 6: 
          localduh.Scene = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32487);
          return 0;
        case 7: 
          localduh.uvG = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32487);
          return 0;
        }
        localduh.uvF = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(32487);
        return 0;
      }
      AppMethodBeat.o(32487);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.duh
 * JD-Core Version:    0.7.0.1
 */