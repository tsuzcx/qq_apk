package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ala
  extends dop
{
  public String KEb;
  public String KQa;
  public String KQf;
  public int LtW;
  public int LtX;
  public String LtY;
  public String LtZ;
  public String Lua;
  public String oUJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(256407);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.oUJ != null) {
        paramVarArgs.e(2, this.oUJ);
      }
      if (this.KEb != null) {
        paramVarArgs.e(3, this.KEb);
      }
      paramVarArgs.aM(4, this.LtW);
      paramVarArgs.aM(5, this.LtX);
      if (this.KQa != null) {
        paramVarArgs.e(6, this.KQa);
      }
      if (this.LtY != null) {
        paramVarArgs.e(7, this.LtY);
      }
      if (this.KQf != null) {
        paramVarArgs.e(8, this.KQf);
      }
      if (this.LtZ != null) {
        paramVarArgs.e(9, this.LtZ);
      }
      if (this.Lua != null) {
        paramVarArgs.e(10, this.Lua);
      }
      AppMethodBeat.o(256407);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label826;
      }
    }
    label826:
    for (int i = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.oUJ != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.oUJ);
      }
      i = paramInt;
      if (this.KEb != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.KEb);
      }
      i = i + g.a.a.b.b.a.bu(4, this.LtW) + g.a.a.b.b.a.bu(5, this.LtX);
      paramInt = i;
      if (this.KQa != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.KQa);
      }
      i = paramInt;
      if (this.LtY != null) {
        i = paramInt + g.a.a.b.b.a.f(7, this.LtY);
      }
      paramInt = i;
      if (this.KQf != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.KQf);
      }
      i = paramInt;
      if (this.LtZ != null) {
        i = paramInt + g.a.a.b.b.a.f(9, this.LtZ);
      }
      paramInt = i;
      if (this.Lua != null) {
        paramInt = i + g.a.a.b.b.a.f(10, this.Lua);
      }
      AppMethodBeat.o(256407);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(256407);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ala localala = (ala)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(256407);
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
            localala.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(256407);
          return 0;
        case 2: 
          localala.oUJ = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(256407);
          return 0;
        case 3: 
          localala.KEb = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(256407);
          return 0;
        case 4: 
          localala.LtW = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(256407);
          return 0;
        case 5: 
          localala.LtX = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(256407);
          return 0;
        case 6: 
          localala.KQa = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(256407);
          return 0;
        case 7: 
          localala.LtY = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(256407);
          return 0;
        case 8: 
          localala.KQf = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(256407);
          return 0;
        case 9: 
          localala.LtZ = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(256407);
          return 0;
        }
        localala.Lua = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(256407);
        return 0;
      }
      AppMethodBeat.o(256407);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ala
 * JD-Core Version:    0.7.0.1
 */