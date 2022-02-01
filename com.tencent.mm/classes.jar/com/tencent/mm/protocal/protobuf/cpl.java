package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cpl
  extends ckq
{
  public String Cxw;
  public String EiY;
  public String EiZ;
  public String Name;
  public String sac;
  public String ubD;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(155459);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.sac != null) {
        paramVarArgs.d(2, this.sac);
      }
      if (this.EiY != null) {
        paramVarArgs.d(3, this.EiY);
      }
      if (this.ubD != null) {
        paramVarArgs.d(5, this.ubD);
      }
      if (this.Name != null) {
        paramVarArgs.d(4, this.Name);
      }
      if (this.Cxw != null) {
        paramVarArgs.d(6, this.Cxw);
      }
      if (this.EiZ != null) {
        paramVarArgs.d(7, this.EiZ);
      }
      AppMethodBeat.o(155459);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label674;
      }
    }
    label674:
    for (int i = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.sac != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.sac);
      }
      i = paramInt;
      if (this.EiY != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.EiY);
      }
      paramInt = i;
      if (this.ubD != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.ubD);
      }
      i = paramInt;
      if (this.Name != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.Name);
      }
      paramInt = i;
      if (this.Cxw != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Cxw);
      }
      i = paramInt;
      if (this.EiZ != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.EiZ);
      }
      AppMethodBeat.o(155459);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(155459);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cpl localcpl = (cpl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(155459);
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
            localcpl.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155459);
          return 0;
        case 2: 
          localcpl.sac = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(155459);
          return 0;
        case 3: 
          localcpl.EiY = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(155459);
          return 0;
        case 5: 
          localcpl.ubD = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(155459);
          return 0;
        case 4: 
          localcpl.Name = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(155459);
          return 0;
        case 6: 
          localcpl.Cxw = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(155459);
          return 0;
        }
        localcpl.EiZ = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(155459);
        return 0;
      }
      AppMethodBeat.o(155459);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cpl
 * JD-Core Version:    0.7.0.1
 */