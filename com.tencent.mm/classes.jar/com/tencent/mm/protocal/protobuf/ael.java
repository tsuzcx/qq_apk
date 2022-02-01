package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class ael
  extends dop
{
  public String LpJ;
  public String LpK;
  public chk LpL;
  public LinkedList<dqi> LpM;
  public String LpN;
  public String LpO;
  public String Name;
  public int oTz;
  
  public ael()
  {
    AppMethodBeat.i(32181);
    this.LpM = new LinkedList();
    AppMethodBeat.o(32181);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32182);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.LpL == null)
      {
        paramVarArgs = new b("Not all required fields were included: Loc");
        AppMethodBeat.o(32182);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Name != null) {
        paramVarArgs.e(2, this.Name);
      }
      if (this.LpJ != null) {
        paramVarArgs.e(3, this.LpJ);
      }
      if (this.LpK != null) {
        paramVarArgs.e(4, this.LpK);
      }
      if (this.LpL != null)
      {
        paramVarArgs.ni(5, this.LpL.computeSize());
        this.LpL.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(6, this.oTz);
      paramVarArgs.e(7, 8, this.LpM);
      if (this.LpN != null) {
        paramVarArgs.e(8, this.LpN);
      }
      if (this.LpO != null) {
        paramVarArgs.e(9, this.LpO);
      }
      AppMethodBeat.o(32182);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1021;
      }
    }
    label1021:
    for (int i = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Name != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.Name);
      }
      i = paramInt;
      if (this.LpJ != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.LpJ);
      }
      paramInt = i;
      if (this.LpK != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.LpK);
      }
      i = paramInt;
      if (this.LpL != null) {
        i = paramInt + g.a.a.a.nh(5, this.LpL.computeSize());
      }
      i = i + g.a.a.b.b.a.bu(6, this.oTz) + g.a.a.a.c(7, 8, this.LpM);
      paramInt = i;
      if (this.LpN != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.LpN);
      }
      i = paramInt;
      if (this.LpO != null) {
        i = paramInt + g.a.a.b.b.a.f(9, this.LpO);
      }
      AppMethodBeat.o(32182);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.LpM.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.LpL == null)
        {
          paramVarArgs = new b("Not all required fields were included: Loc");
          AppMethodBeat.o(32182);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32182);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ael localael = (ael)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32182);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jr();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jr)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localael.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32182);
          return 0;
        case 2: 
          localael.Name = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32182);
          return 0;
        case 3: 
          localael.LpJ = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32182);
          return 0;
        case 4: 
          localael.LpK = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32182);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new chk();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((chk)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localael.LpL = ((chk)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32182);
          return 0;
        case 6: 
          localael.oTz = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32182);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dqi();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dqi)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localael.LpM.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32182);
          return 0;
        case 8: 
          localael.LpN = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32182);
          return 0;
        }
        localael.LpO = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(32182);
        return 0;
      }
      AppMethodBeat.o(32182);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ael
 * JD-Core Version:    0.7.0.1
 */