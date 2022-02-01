package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class akz
  extends ckq
{
  public aht Dkw;
  public String dnB;
  public int offset;
  public b qHz;
  public String query;
  public int scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169048);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.query != null) {
        paramVarArgs.d(2, this.query);
      }
      paramVarArgs.aR(3, this.offset);
      if (this.qHz != null) {
        paramVarArgs.c(4, this.qHz);
      }
      paramVarArgs.aR(5, this.scene);
      if (this.dnB != null) {
        paramVarArgs.d(6, this.dnB);
      }
      if (this.Dkw != null)
      {
        paramVarArgs.kX(7, this.Dkw.computeSize());
        this.Dkw.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(169048);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label738;
      }
    }
    label738:
    for (paramInt = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.query != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.query);
      }
      i += f.a.a.b.b.a.bA(3, this.offset);
      paramInt = i;
      if (this.qHz != null) {
        paramInt = i + f.a.a.b.b.a.b(4, this.qHz);
      }
      i = paramInt + f.a.a.b.b.a.bA(5, this.scene);
      paramInt = i;
      if (this.dnB != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.dnB);
      }
      i = paramInt;
      if (this.Dkw != null) {
        i = paramInt + f.a.a.a.kW(7, this.Dkw.computeSize());
      }
      AppMethodBeat.o(169048);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(169048);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        akz localakz = (akz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(169048);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ip();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ip)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localakz.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169048);
          return 0;
        case 2: 
          localakz.query = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(169048);
          return 0;
        case 3: 
          localakz.offset = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(169048);
          return 0;
        case 4: 
          localakz.qHz = ((f.a.a.a.a)localObject1).KhF.fMu();
          AppMethodBeat.o(169048);
          return 0;
        case 5: 
          localakz.scene = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(169048);
          return 0;
        case 6: 
          localakz.dnB = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(169048);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new aht();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((aht)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localakz.Dkw = ((aht)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(169048);
        return 0;
      }
      AppMethodBeat.o(169048);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.akz
 * JD-Core Version:    0.7.0.1
 */