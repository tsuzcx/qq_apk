package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dsf
  extends cvw
{
  public String FSh;
  public String Gps;
  public String Name;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(155472);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Gps != null) {
        paramVarArgs.d(2, this.Gps);
      }
      if (this.Name != null) {
        paramVarArgs.d(3, this.Name);
      }
      if (this.FSh != null) {
        paramVarArgs.d(4, this.FSh);
      }
      AppMethodBeat.o(155472);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label490;
      }
    }
    label490:
    for (int i = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Gps != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Gps);
      }
      i = paramInt;
      if (this.Name != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Name);
      }
      paramInt = i;
      if (this.FSh != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.FSh);
      }
      AppMethodBeat.o(155472);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(155472);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dsf localdsf = (dsf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(155472);
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
            localdsf.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155472);
          return 0;
        case 2: 
          localdsf.Gps = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(155472);
          return 0;
        case 3: 
          localdsf.Name = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(155472);
          return 0;
        }
        localdsf.FSh = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(155472);
        return 0;
      }
      AppMethodBeat.o(155472);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dsf
 * JD-Core Version:    0.7.0.1
 */