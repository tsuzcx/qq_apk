package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class ct
  extends com.tencent.mm.bx.a
{
  public int CreateTime;
  public int CxE;
  public cmf CxF;
  public int CxG;
  public cmf CxH;
  public int CxI;
  public int saz;
  public long uKZ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133144);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.CxF == null)
      {
        paramVarArgs = new b("Not all required fields were included: ChatRoomId");
        AppMethodBeat.o(133144);
        throw paramVarArgs;
      }
      if (this.CxH == null)
      {
        paramVarArgs = new b("Not all required fields were included: DigestContent");
        AppMethodBeat.o(133144);
        throw paramVarArgs;
      }
      if (this.CxF != null)
      {
        paramVarArgs.kX(1, this.CxF.computeSize());
        this.CxF.writeFields(paramVarArgs);
      }
      paramVarArgs.aG(2, this.uKZ);
      paramVarArgs.aR(3, this.CxE);
      paramVarArgs.aR(4, this.CreateTime);
      paramVarArgs.aR(5, this.CxG);
      if (this.CxH != null)
      {
        paramVarArgs.kX(6, this.CxH.computeSize());
        this.CxH.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(7, this.CxI);
      paramVarArgs.aR(8, this.saz);
      AppMethodBeat.o(133144);
      return 0;
    }
    if (paramInt == 1) {
      if (this.CxF == null) {
        break label826;
      }
    }
    label826:
    for (paramInt = f.a.a.a.kW(1, this.CxF.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.q(2, this.uKZ) + f.a.a.b.b.a.bA(3, this.CxE) + f.a.a.b.b.a.bA(4, this.CreateTime) + f.a.a.b.b.a.bA(5, this.CxG);
      paramInt = i;
      if (this.CxH != null) {
        paramInt = i + f.a.a.a.kW(6, this.CxH.computeSize());
      }
      i = f.a.a.b.b.a.bA(7, this.CxI);
      int j = f.a.a.b.b.a.bA(8, this.saz);
      AppMethodBeat.o(133144);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.CxF == null)
        {
          paramVarArgs = new b("Not all required fields were included: ChatRoomId");
          AppMethodBeat.o(133144);
          throw paramVarArgs;
        }
        if (this.CxH == null)
        {
          paramVarArgs = new b("Not all required fields were included: DigestContent");
          AppMethodBeat.o(133144);
          throw paramVarArgs;
        }
        AppMethodBeat.o(133144);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ct localct = (ct)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(133144);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cmf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cmf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localct.CxF = ((cmf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133144);
          return 0;
        case 2: 
          localct.uKZ = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(133144);
          return 0;
        case 3: 
          localct.CxE = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(133144);
          return 0;
        case 4: 
          localct.CreateTime = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(133144);
          return 0;
        case 5: 
          localct.CxG = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(133144);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cmf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cmf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localct.CxH = ((cmf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133144);
          return 0;
        case 7: 
          localct.CxI = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(133144);
          return 0;
        }
        localct.saz = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(133144);
        return 0;
      }
      AppMethodBeat.o(133144);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ct
 * JD-Core Version:    0.7.0.1
 */