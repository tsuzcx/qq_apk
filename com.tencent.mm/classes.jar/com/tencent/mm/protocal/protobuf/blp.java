package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class blp
  extends com.tencent.mm.bx.a
{
  public blo DJq;
  public blr DJr;
  public String Dds;
  public PersonalDesigner Dtg;
  public String Name;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104818);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Dds != null) {
        paramVarArgs.d(1, this.Dds);
      }
      if (this.DJq != null)
      {
        paramVarArgs.kX(2, this.DJq.computeSize());
        this.DJq.writeFields(paramVarArgs);
      }
      if (this.Name != null) {
        paramVarArgs.d(3, this.Name);
      }
      if (this.Dtg != null)
      {
        paramVarArgs.kX(4, this.Dtg.computeSize());
        this.Dtg.writeFields(paramVarArgs);
      }
      if (this.DJr != null)
      {
        paramVarArgs.kX(5, this.DJr.computeSize());
        this.DJr.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(104818);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Dds == null) {
        break label738;
      }
    }
    label738:
    for (int i = f.a.a.b.b.a.e(1, this.Dds) + 0;; i = 0)
    {
      paramInt = i;
      if (this.DJq != null) {
        paramInt = i + f.a.a.a.kW(2, this.DJq.computeSize());
      }
      i = paramInt;
      if (this.Name != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Name);
      }
      paramInt = i;
      if (this.Dtg != null) {
        paramInt = i + f.a.a.a.kW(4, this.Dtg.computeSize());
      }
      i = paramInt;
      if (this.DJr != null) {
        i = paramInt + f.a.a.a.kW(5, this.DJr.computeSize());
      }
      AppMethodBeat.o(104818);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(104818);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        blp localblp = (blp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(104818);
          return -1;
        case 1: 
          localblp.Dds = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(104818);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new blo();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((blo)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localblp.DJq = ((blo)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(104818);
          return 0;
        case 3: 
          localblp.Name = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(104818);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new PersonalDesigner();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((PersonalDesigner)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localblp.Dtg = ((PersonalDesigner)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(104818);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new blr();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((blr)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localblp.DJr = ((blr)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(104818);
        return 0;
      }
      AppMethodBeat.o(104818);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.blp
 * JD-Core Version:    0.7.0.1
 */