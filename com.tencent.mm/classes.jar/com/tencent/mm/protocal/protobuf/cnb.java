package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cnb
  extends ckq
{
  public int DRi;
  public LinkedList<String> DRj;
  public int Dbx;
  public String EhK;
  public String EhL;
  public String dlB;
  public String state;
  
  public cnb()
  {
    AppMethodBeat.i(82470);
    this.DRj = new LinkedList();
    AppMethodBeat.o(82470);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82471);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(3, this.DRi);
      paramVarArgs.e(4, 1, this.DRj);
      if (this.dlB != null) {
        paramVarArgs.d(5, this.dlB);
      }
      if (this.state != null) {
        paramVarArgs.d(6, this.state);
      }
      if (this.EhK != null) {
        paramVarArgs.d(7, this.EhK);
      }
      paramVarArgs.aR(8, this.Dbx);
      if (this.EhL != null) {
        paramVarArgs.d(14, this.EhL);
      }
      AppMethodBeat.o(82471);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label726;
      }
    }
    label726:
    for (paramInt = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(3, this.DRi) + f.a.a.a.c(4, 1, this.DRj);
      paramInt = i;
      if (this.dlB != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.dlB);
      }
      i = paramInt;
      if (this.state != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.state);
      }
      paramInt = i;
      if (this.EhK != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.EhK);
      }
      i = paramInt + f.a.a.b.b.a.bA(8, this.Dbx);
      paramInt = i;
      if (this.EhL != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.EhL);
      }
      AppMethodBeat.o(82471);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.DRj.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(82471);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cnb localcnb = (cnb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 2: 
        case 9: 
        case 10: 
        case 11: 
        case 12: 
        case 13: 
        default: 
          AppMethodBeat.o(82471);
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
            localcnb.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(82471);
          return 0;
        case 3: 
          localcnb.DRi = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(82471);
          return 0;
        case 4: 
          localcnb.DRj.add(((f.a.a.a.a)localObject1).KhF.readString());
          AppMethodBeat.o(82471);
          return 0;
        case 5: 
          localcnb.dlB = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(82471);
          return 0;
        case 6: 
          localcnb.state = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(82471);
          return 0;
        case 7: 
          localcnb.EhK = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(82471);
          return 0;
        case 8: 
          localcnb.Dbx = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(82471);
          return 0;
        }
        localcnb.EhL = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(82471);
        return 0;
      }
      AppMethodBeat.o(82471);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cnb
 * JD-Core Version:    0.7.0.1
 */