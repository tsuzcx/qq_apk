package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class deb
  extends cld
{
  public String EvD;
  public LinkedList<bgf> EvF;
  public boolean bOX;
  public int ntx;
  public String nty;
  
  public deb()
  {
    AppMethodBeat.i(72595);
    this.EvF = new LinkedList();
    AppMethodBeat.o(72595);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72596);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.ntx);
      if (this.nty != null) {
        paramVarArgs.d(3, this.nty);
      }
      paramVarArgs.e(4, 8, this.EvF);
      paramVarArgs.bg(5, this.bOX);
      if (this.EvD != null) {
        paramVarArgs.d(6, this.EvD);
      }
      AppMethodBeat.o(72596);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label658;
      }
    }
    label658:
    for (paramInt = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.ntx);
      paramInt = i;
      if (this.nty != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.nty);
      }
      i = paramInt + f.a.a.a.c(4, 8, this.EvF) + (f.a.a.b.b.a.fY(5) + 1);
      paramInt = i;
      if (this.EvD != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.EvD);
      }
      AppMethodBeat.o(72596);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.EvF.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cld.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cld.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(72596);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        deb localdeb = (deb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72596);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdeb.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72596);
          return 0;
        case 2: 
          localdeb.ntx = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(72596);
          return 0;
        case 3: 
          localdeb.nty = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72596);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bgf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bgf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdeb.EvF.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72596);
          return 0;
        case 5: 
          localdeb.bOX = ((f.a.a.a.a)localObject1).KhF.fHu();
          AppMethodBeat.o(72596);
          return 0;
        }
        localdeb.EvD = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(72596);
        return 0;
      }
      AppMethodBeat.o(72596);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.deb
 * JD-Core Version:    0.7.0.1
 */