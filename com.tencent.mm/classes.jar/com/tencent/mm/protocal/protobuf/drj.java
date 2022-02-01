package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class drj
  extends dop
{
  public String MTQ;
  public String MTR;
  public b MTS;
  public String MTY;
  public String MTZ;
  public String dNI;
  public String scope;
  public String state;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82473);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.dNI != null) {
        paramVarArgs.e(2, this.dNI);
      }
      if (this.scope != null) {
        paramVarArgs.e(3, this.scope);
      }
      if (this.state != null) {
        paramVarArgs.e(4, this.state);
      }
      if (this.MTQ != null) {
        paramVarArgs.e(5, this.MTQ);
      }
      if (this.MTY != null) {
        paramVarArgs.e(6, this.MTY);
      }
      if (this.MTZ != null) {
        paramVarArgs.e(7, this.MTZ);
      }
      if (this.MTR != null) {
        paramVarArgs.e(13, this.MTR);
      }
      if (this.MTS != null) {
        paramVarArgs.c(14, this.MTS);
      }
      AppMethodBeat.o(82473);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label818;
      }
    }
    label818:
    for (int i = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.dNI != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.dNI);
      }
      i = paramInt;
      if (this.scope != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.scope);
      }
      paramInt = i;
      if (this.state != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.state);
      }
      i = paramInt;
      if (this.MTQ != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.MTQ);
      }
      paramInt = i;
      if (this.MTY != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.MTY);
      }
      i = paramInt;
      if (this.MTZ != null) {
        i = paramInt + g.a.a.b.b.a.f(7, this.MTZ);
      }
      paramInt = i;
      if (this.MTR != null) {
        paramInt = i + g.a.a.b.b.a.f(13, this.MTR);
      }
      i = paramInt;
      if (this.MTS != null) {
        i = paramInt + g.a.a.b.b.a.b(14, this.MTS);
      }
      AppMethodBeat.o(82473);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(82473);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        drj localdrj = (drj)paramVarArgs[1];
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
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jr();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((jr)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdrj.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(82473);
          return 0;
        case 2: 
          localdrj.dNI = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(82473);
          return 0;
        case 3: 
          localdrj.scope = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(82473);
          return 0;
        case 4: 
          localdrj.state = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(82473);
          return 0;
        case 5: 
          localdrj.MTQ = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(82473);
          return 0;
        case 6: 
          localdrj.MTY = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(82473);
          return 0;
        case 7: 
          localdrj.MTZ = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(82473);
          return 0;
        case 13: 
          localdrj.MTR = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(82473);
          return 0;
        }
        localdrj.MTS = ((g.a.a.a.a)localObject1).UbS.hPo();
        AppMethodBeat.o(82473);
        return 0;
      }
      AppMethodBeat.o(82473);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.drj
 * JD-Core Version:    0.7.0.1
 */