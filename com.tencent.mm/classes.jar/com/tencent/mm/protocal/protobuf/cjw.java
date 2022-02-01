package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cjw
  extends cvw
{
  public int Hwm;
  public String Hwo;
  public String Hwp;
  public String Hwq;
  public String language;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91587);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.Hwm);
      if (this.language != null) {
        paramVarArgs.d(3, this.language);
      }
      if (this.Hwo != null) {
        paramVarArgs.d(4, this.Hwo);
      }
      if (this.Hwp != null) {
        paramVarArgs.d(5, this.Hwp);
      }
      if (this.Hwq != null) {
        paramVarArgs.d(6, this.Hwq);
      }
      AppMethodBeat.o(91587);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label598;
      }
    }
    label598:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.Hwm);
      paramInt = i;
      if (this.language != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.language);
      }
      i = paramInt;
      if (this.Hwo != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.Hwo);
      }
      paramInt = i;
      if (this.Hwp != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.Hwp);
      }
      i = paramInt;
      if (this.Hwq != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.Hwq);
      }
      AppMethodBeat.o(91587);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(91587);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cjw localcjw = (cjw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91587);
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
            localcjw.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91587);
          return 0;
        case 2: 
          localcjw.Hwm = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91587);
          return 0;
        case 3: 
          localcjw.language = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91587);
          return 0;
        case 4: 
          localcjw.Hwo = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91587);
          return 0;
        case 5: 
          localcjw.Hwp = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91587);
          return 0;
        }
        localcjw.Hwq = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(91587);
        return 0;
      }
      AppMethodBeat.o(91587);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cjw
 * JD-Core Version:    0.7.0.1
 */