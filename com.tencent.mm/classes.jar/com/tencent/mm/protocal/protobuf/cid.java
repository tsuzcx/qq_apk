package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cid
  extends ckq
{
  public String CYT;
  public int CYU;
  public int DXY;
  public String DYc;
  public String DYd;
  public String zFY;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91665);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.DXY);
      if (this.DYd != null) {
        paramVarArgs.d(3, this.DYd);
      }
      if (this.CYT != null) {
        paramVarArgs.d(4, this.CYT);
      }
      paramVarArgs.aR(5, this.CYU);
      if (this.DYc != null) {
        paramVarArgs.d(6, this.DYc);
      }
      if (this.zFY != null) {
        paramVarArgs.d(100, this.zFY);
      }
      AppMethodBeat.o(91665);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label666;
      }
    }
    label666:
    for (paramInt = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.DXY);
      paramInt = i;
      if (this.DYd != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.DYd);
      }
      i = paramInt;
      if (this.CYT != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.CYT);
      }
      i += f.a.a.b.b.a.bA(5, this.CYU);
      paramInt = i;
      if (this.DYc != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.DYc);
      }
      i = paramInt;
      if (this.zFY != null) {
        i = paramInt + f.a.a.b.b.a.e(100, this.zFY);
      }
      AppMethodBeat.o(91665);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(91665);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cid localcid = (cid)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91665);
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
            localcid.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91665);
          return 0;
        case 2: 
          localcid.DXY = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91665);
          return 0;
        case 3: 
          localcid.DYd = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91665);
          return 0;
        case 4: 
          localcid.CYT = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91665);
          return 0;
        case 5: 
          localcid.CYU = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91665);
          return 0;
        case 6: 
          localcid.DYc = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91665);
          return 0;
        }
        localcid.zFY = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(91665);
        return 0;
      }
      AppMethodBeat.o(91665);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cid
 * JD-Core Version:    0.7.0.1
 */