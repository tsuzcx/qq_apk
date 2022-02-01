package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class gg
  extends com.tencent.mm.bx.a
{
  public String CAR;
  public gh CAS;
  public String Cxw;
  public String Name;
  public String Title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125712);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.CAS == null)
      {
        paramVarArgs = new b("Not all required fields were included: ArtisIcon");
        AppMethodBeat.o(125712);
        throw paramVarArgs;
      }
      if (this.Name != null) {
        paramVarArgs.d(1, this.Name);
      }
      if (this.Title != null) {
        paramVarArgs.d(2, this.Title);
      }
      if (this.CAR != null) {
        paramVarArgs.d(3, this.CAR);
      }
      if (this.Cxw != null) {
        paramVarArgs.d(4, this.Cxw);
      }
      if (this.CAS != null)
      {
        paramVarArgs.kX(5, this.CAS.computeSize());
        this.CAS.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(125712);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Name == null) {
        break label598;
      }
    }
    label598:
    for (int i = f.a.a.b.b.a.e(1, this.Name) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Title != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Title);
      }
      i = paramInt;
      if (this.CAR != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.CAR);
      }
      paramInt = i;
      if (this.Cxw != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Cxw);
      }
      i = paramInt;
      if (this.CAS != null) {
        i = paramInt + f.a.a.a.kW(5, this.CAS.computeSize());
      }
      AppMethodBeat.o(125712);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.CAS == null)
        {
          paramVarArgs = new b("Not all required fields were included: ArtisIcon");
          AppMethodBeat.o(125712);
          throw paramVarArgs;
        }
        AppMethodBeat.o(125712);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        gg localgg = (gg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125712);
          return -1;
        case 1: 
          localgg.Name = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(125712);
          return 0;
        case 2: 
          localgg.Title = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(125712);
          return 0;
        case 3: 
          localgg.CAR = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(125712);
          return 0;
        case 4: 
          localgg.Cxw = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(125712);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new gh();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((gh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localgg.CAS = ((gh)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125712);
        return 0;
      }
      AppMethodBeat.o(125712);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gg
 * JD-Core Version:    0.7.0.1
 */