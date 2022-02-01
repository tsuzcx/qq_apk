package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class daw
  extends cvw
{
  public String FNF;
  public String HJZ;
  public String HKa;
  public String Name;
  public String urg;
  public String wFC;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(155459);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.urg != null) {
        paramVarArgs.d(2, this.urg);
      }
      if (this.HJZ != null) {
        paramVarArgs.d(3, this.HJZ);
      }
      if (this.wFC != null) {
        paramVarArgs.d(5, this.wFC);
      }
      if (this.Name != null) {
        paramVarArgs.d(4, this.Name);
      }
      if (this.FNF != null) {
        paramVarArgs.d(6, this.FNF);
      }
      if (this.HKa != null) {
        paramVarArgs.d(7, this.HKa);
      }
      AppMethodBeat.o(155459);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label674;
      }
    }
    label674:
    for (int i = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.urg != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.urg);
      }
      i = paramInt;
      if (this.HJZ != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.HJZ);
      }
      paramInt = i;
      if (this.wFC != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.wFC);
      }
      i = paramInt;
      if (this.Name != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.Name);
      }
      paramInt = i;
      if (this.FNF != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.FNF);
      }
      i = paramInt;
      if (this.HKa != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.HKa);
      }
      AppMethodBeat.o(155459);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(155459);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        daw localdaw = (daw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(155459);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdaw.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155459);
          return 0;
        case 2: 
          localdaw.urg = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(155459);
          return 0;
        case 3: 
          localdaw.HJZ = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(155459);
          return 0;
        case 5: 
          localdaw.wFC = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(155459);
          return 0;
        case 4: 
          localdaw.Name = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(155459);
          return 0;
        case 6: 
          localdaw.FNF = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(155459);
          return 0;
        }
        localdaw.HKa = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(155459);
        return 0;
      }
      AppMethodBeat.o(155459);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.daw
 * JD-Core Version:    0.7.0.1
 */