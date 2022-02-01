package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class deh
  extends cld
{
  public String EvE;
  public int EvL;
  public LinkedList<bjt> EvM;
  public bjt EvN;
  public int ntx;
  public String nty;
  public String subtitle;
  public String title;
  
  public deh()
  {
    AppMethodBeat.i(72603);
    this.EvM = new LinkedList();
    AppMethodBeat.o(72603);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72604);
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
      if (this.title != null) {
        paramVarArgs.d(4, this.title);
      }
      if (this.subtitle != null) {
        paramVarArgs.d(5, this.subtitle);
      }
      paramVarArgs.aR(6, this.EvL);
      paramVarArgs.e(7, 8, this.EvM);
      if (this.EvN != null)
      {
        paramVarArgs.kX(8, this.EvN.computeSize());
        this.EvN.writeFields(paramVarArgs);
      }
      if (this.EvE != null) {
        paramVarArgs.d(9, this.EvE);
      }
      AppMethodBeat.o(72604);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label938;
      }
    }
    label938:
    for (paramInt = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.ntx);
      paramInt = i;
      if (this.nty != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.nty);
      }
      i = paramInt;
      if (this.title != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.title);
      }
      paramInt = i;
      if (this.subtitle != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.subtitle);
      }
      i = paramInt + f.a.a.b.b.a.bA(6, this.EvL) + f.a.a.a.c(7, 8, this.EvM);
      paramInt = i;
      if (this.EvN != null) {
        paramInt = i + f.a.a.a.kW(8, this.EvN.computeSize());
      }
      i = paramInt;
      if (this.EvE != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.EvE);
      }
      AppMethodBeat.o(72604);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.EvM.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cld.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cld.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(72604);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        deh localdeh = (deh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72604);
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
            localdeh.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72604);
          return 0;
        case 2: 
          localdeh.ntx = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(72604);
          return 0;
        case 3: 
          localdeh.nty = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72604);
          return 0;
        case 4: 
          localdeh.title = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72604);
          return 0;
        case 5: 
          localdeh.subtitle = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72604);
          return 0;
        case 6: 
          localdeh.EvL = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(72604);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bjt();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bjt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdeh.EvM.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72604);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bjt();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bjt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdeh.EvN = ((bjt)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72604);
          return 0;
        }
        localdeh.EvE = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(72604);
        return 0;
      }
      AppMethodBeat.o(72604);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.deh
 * JD-Core Version:    0.7.0.1
 */