package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dwl
  extends com.tencent.mm.bx.a
{
  public int CHC;
  public dwf EKf;
  public String EKw;
  public String Md5;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153344);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.EKf != null)
      {
        paramVarArgs.kX(1, this.EKf.computeSize());
        this.EKf.writeFields(paramVarArgs);
      }
      if (this.EKw != null) {
        paramVarArgs.d(2, this.EKw);
      }
      paramVarArgs.aR(3, this.CHC);
      if (this.Md5 != null) {
        paramVarArgs.d(4, this.Md5);
      }
      AppMethodBeat.o(153344);
      return 0;
    }
    if (paramInt == 1) {
      if (this.EKf == null) {
        break label474;
      }
    }
    label474:
    for (paramInt = f.a.a.a.kW(1, this.EKf.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.EKw != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.EKw);
      }
      i += f.a.a.b.b.a.bA(3, this.CHC);
      paramInt = i;
      if (this.Md5 != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Md5);
      }
      AppMethodBeat.o(153344);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(153344);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dwl localdwl = (dwl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(153344);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dwf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((dwf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdwl.EKf = ((dwf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153344);
          return 0;
        case 2: 
          localdwl.EKw = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(153344);
          return 0;
        case 3: 
          localdwl.CHC = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(153344);
          return 0;
        }
        localdwl.Md5 = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(153344);
        return 0;
      }
      AppMethodBeat.o(153344);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dwl
 * JD-Core Version:    0.7.0.1
 */