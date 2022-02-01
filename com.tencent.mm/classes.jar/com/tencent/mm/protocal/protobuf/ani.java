package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ani
  extends ckq
{
  public LinkedList<String> Doq;
  public LinkedList<String> Dow;
  public int Dox;
  public String ijV;
  public String sbA;
  
  public ani()
  {
    AppMethodBeat.i(42638);
    this.Dow = new LinkedList();
    this.Doq = new LinkedList();
    AppMethodBeat.o(42638);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(42639);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 1, this.Dow);
      paramVarArgs.e(3, 1, this.Doq);
      if (this.sbA != null) {
        paramVarArgs.d(4, this.sbA);
      }
      if (this.ijV != null) {
        paramVarArgs.d(5, this.ijV);
      }
      paramVarArgs.aR(6, this.Dox);
      AppMethodBeat.o(42639);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label590;
      }
    }
    label590:
    for (paramInt = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.a.c(2, 1, this.Dow) + f.a.a.a.c(3, 1, this.Doq);
      paramInt = i;
      if (this.sbA != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.sbA);
      }
      i = paramInt;
      if (this.ijV != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.ijV);
      }
      paramInt = f.a.a.b.b.a.bA(6, this.Dox);
      AppMethodBeat.o(42639);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Dow.clear();
        this.Doq.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(42639);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ani localani = (ani)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(42639);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ip();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((ip)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localani.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(42639);
          return 0;
        case 2: 
          localani.Dow.add(((f.a.a.a.a)localObject1).KhF.readString());
          AppMethodBeat.o(42639);
          return 0;
        case 3: 
          localani.Doq.add(((f.a.a.a.a)localObject1).KhF.readString());
          AppMethodBeat.o(42639);
          return 0;
        case 4: 
          localani.sbA = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(42639);
          return 0;
        case 5: 
          localani.ijV = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(42639);
          return 0;
        }
        localani.Dox = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(42639);
        return 0;
      }
      AppMethodBeat.o(42639);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ani
 * JD-Core Version:    0.7.0.1
 */