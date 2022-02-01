package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bxi
  extends com.tencent.mm.bx.a
{
  public LinkedList<bxi> AuU;
  public String DTN;
  public LinkedList<bxh> DTO;
  public int DTP;
  public int DTQ;
  public int nUh;
  public String type;
  public String upD;
  
  public bxi()
  {
    AppMethodBeat.i(117537);
    this.DTO = new LinkedList();
    this.AuU = new LinkedList();
    AppMethodBeat.o(117537);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117538);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DTN != null) {
        paramVarArgs.d(1, this.DTN);
      }
      if (this.upD != null) {
        paramVarArgs.d(2, this.upD);
      }
      paramVarArgs.e(3, 8, this.DTO);
      paramVarArgs.aR(4, this.nUh);
      if (this.type != null) {
        paramVarArgs.d(5, this.type);
      }
      paramVarArgs.e(6, 8, this.AuU);
      paramVarArgs.aR(7, this.DTP);
      paramVarArgs.aR(8, this.DTQ);
      AppMethodBeat.o(117538);
      return 0;
    }
    if (paramInt == 1) {
      if (this.DTN == null) {
        break label758;
      }
    }
    label758:
    for (paramInt = f.a.a.b.b.a.e(1, this.DTN) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.upD != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.upD);
      }
      i = i + f.a.a.a.c(3, 8, this.DTO) + f.a.a.b.b.a.bA(4, this.nUh);
      paramInt = i;
      if (this.type != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.type);
      }
      i = f.a.a.a.c(6, 8, this.AuU);
      int j = f.a.a.b.b.a.bA(7, this.DTP);
      int k = f.a.a.b.b.a.bA(8, this.DTQ);
      AppMethodBeat.o(117538);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.DTO.clear();
        this.AuU.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(117538);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bxi localbxi = (bxi)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(117538);
          return -1;
        case 1: 
          localbxi.DTN = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(117538);
          return 0;
        case 2: 
          localbxi.upD = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(117538);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bxh();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bxh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbxi.DTO.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117538);
          return 0;
        case 4: 
          localbxi.nUh = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(117538);
          return 0;
        case 5: 
          localbxi.type = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(117538);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bxi();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bxi)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbxi.AuU.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117538);
          return 0;
        case 7: 
          localbxi.DTP = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(117538);
          return 0;
        }
        localbxi.DTQ = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(117538);
        return 0;
      }
      AppMethodBeat.o(117538);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bxi
 * JD-Core Version:    0.7.0.1
 */