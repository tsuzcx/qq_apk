package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cbx
  extends cvw
{
  public String CPZ;
  public String Gro;
  public dns HoY;
  public int time_stamp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72523);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.time_stamp);
      if (this.Gro != null) {
        paramVarArgs.d(3, this.Gro);
      }
      if (this.HoY != null)
      {
        paramVarArgs.lJ(4, this.HoY.computeSize());
        this.HoY.writeFields(paramVarArgs);
      }
      if (this.CPZ != null) {
        paramVarArgs.d(100, this.CPZ);
      }
      AppMethodBeat.o(72523);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label646;
      }
    }
    label646:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.time_stamp);
      paramInt = i;
      if (this.Gro != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.Gro);
      }
      i = paramInt;
      if (this.HoY != null) {
        i = paramInt + f.a.a.a.lI(4, this.HoY.computeSize());
      }
      paramInt = i;
      if (this.CPZ != null) {
        paramInt = i + f.a.a.b.b.a.e(100, this.CPZ);
      }
      AppMethodBeat.o(72523);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(72523);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cbx localcbx = (cbx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72523);
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
            localcbx.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72523);
          return 0;
        case 2: 
          localcbx.time_stamp = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(72523);
          return 0;
        case 3: 
          localcbx.Gro = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72523);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dns();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dns)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcbx.HoY = ((dns)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72523);
          return 0;
        }
        localcbx.CPZ = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(72523);
        return 0;
      }
      AppMethodBeat.o(72523);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cbx
 * JD-Core Version:    0.7.0.1
 */