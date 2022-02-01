package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cnd
  extends ckq
{
  public String EhK;
  public String EhL;
  public String EhM;
  public String EhN;
  public String dlB;
  public String scope;
  public String state;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82473);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.dlB != null) {
        paramVarArgs.d(2, this.dlB);
      }
      if (this.scope != null) {
        paramVarArgs.d(3, this.scope);
      }
      if (this.state != null) {
        paramVarArgs.d(4, this.state);
      }
      if (this.EhK != null) {
        paramVarArgs.d(5, this.EhK);
      }
      if (this.EhM != null) {
        paramVarArgs.d(6, this.EhM);
      }
      if (this.EhN != null) {
        paramVarArgs.d(7, this.EhN);
      }
      if (this.EhL != null) {
        paramVarArgs.d(13, this.EhL);
      }
      AppMethodBeat.o(82473);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label758;
      }
    }
    label758:
    for (int i = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.dlB != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.dlB);
      }
      i = paramInt;
      if (this.scope != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.scope);
      }
      paramInt = i;
      if (this.state != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.state);
      }
      i = paramInt;
      if (this.EhK != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.EhK);
      }
      paramInt = i;
      if (this.EhM != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.EhM);
      }
      i = paramInt;
      if (this.EhN != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.EhN);
      }
      paramInt = i;
      if (this.EhL != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.EhL);
      }
      AppMethodBeat.o(82473);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(82473);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cnd localcnd = (cnd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 8: 
        case 9: 
        case 10: 
        case 11: 
        case 12: 
        default: 
          AppMethodBeat.o(82473);
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
            localcnd.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(82473);
          return 0;
        case 2: 
          localcnd.dlB = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(82473);
          return 0;
        case 3: 
          localcnd.scope = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(82473);
          return 0;
        case 4: 
          localcnd.state = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(82473);
          return 0;
        case 5: 
          localcnd.EhK = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(82473);
          return 0;
        case 6: 
          localcnd.EhM = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(82473);
          return 0;
        case 7: 
          localcnd.EhN = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(82473);
          return 0;
        }
        localcnd.EhL = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(82473);
        return 0;
      }
      AppMethodBeat.o(82473);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cnd
 * JD-Core Version:    0.7.0.1
 */