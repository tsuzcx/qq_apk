package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eek
  extends com.tencent.mm.bw.a
{
  public int CreateTime;
  public String Id;
  public dlg NeA;
  public edk NeB;
  public String NeC;
  public int NeD;
  public int NeE;
  public String UserName;
  public long timeStamp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118475);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Id != null) {
        paramVarArgs.e(1, this.Id);
      }
      if (this.UserName != null) {
        paramVarArgs.e(2, this.UserName);
      }
      paramVarArgs.aM(3, this.CreateTime);
      if (this.NeA != null)
      {
        paramVarArgs.ni(4, this.NeA.computeSize());
        this.NeA.writeFields(paramVarArgs);
      }
      if (this.NeB != null)
      {
        paramVarArgs.ni(5, this.NeB.computeSize());
        this.NeB.writeFields(paramVarArgs);
      }
      paramVarArgs.bb(6, this.timeStamp);
      if (this.NeC != null) {
        paramVarArgs.e(7, this.NeC);
      }
      paramVarArgs.aM(8, this.NeD);
      paramVarArgs.aM(9, this.NeE);
      AppMethodBeat.o(118475);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Id == null) {
        break label830;
      }
    }
    label830:
    for (paramInt = g.a.a.b.b.a.f(1, this.Id) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.UserName != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.UserName);
      }
      i += g.a.a.b.b.a.bu(3, this.CreateTime);
      paramInt = i;
      if (this.NeA != null) {
        paramInt = i + g.a.a.a.nh(4, this.NeA.computeSize());
      }
      i = paramInt;
      if (this.NeB != null) {
        i = paramInt + g.a.a.a.nh(5, this.NeB.computeSize());
      }
      i += g.a.a.b.b.a.r(6, this.timeStamp);
      paramInt = i;
      if (this.NeC != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.NeC);
      }
      i = g.a.a.b.b.a.bu(8, this.NeD);
      int j = g.a.a.b.b.a.bu(9, this.NeE);
      AppMethodBeat.o(118475);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(118475);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        eek localeek = (eek)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(118475);
          return -1;
        case 1: 
          localeek.Id = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(118475);
          return 0;
        case 2: 
          localeek.UserName = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(118475);
          return 0;
        case 3: 
          localeek.CreateTime = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(118475);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dlg();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dlg)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localeek.NeA = ((dlg)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(118475);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new edk();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((edk)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localeek.NeB = ((edk)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(118475);
          return 0;
        case 6: 
          localeek.timeStamp = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(118475);
          return 0;
        case 7: 
          localeek.NeC = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(118475);
          return 0;
        case 8: 
          localeek.NeD = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(118475);
          return 0;
        }
        localeek.NeE = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(118475);
        return 0;
      }
      AppMethodBeat.o(118475);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eek
 * JD-Core Version:    0.7.0.1
 */