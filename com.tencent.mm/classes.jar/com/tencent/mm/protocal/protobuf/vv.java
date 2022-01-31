package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class vv
  extends buy
{
  public int iFL;
  public String oiG;
  public String wKl;
  public String wKp;
  public String wOx;
  public long wOy;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(48828);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.wOx != null) {
        paramVarArgs.e(2, this.wOx);
      }
      paramVarArgs.am(3, this.wOy);
      if (this.wKl != null) {
        paramVarArgs.e(4, this.wKl);
      }
      if (this.wKp != null) {
        paramVarArgs.e(5, this.wKp);
      }
      paramVarArgs.aO(6, this.iFL);
      if (this.oiG != null) {
        paramVarArgs.e(7, this.oiG);
      }
      AppMethodBeat.o(48828);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label642;
      }
    }
    label642:
    for (paramInt = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.wOx != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.wOx);
      }
      i += e.a.a.b.b.a.p(3, this.wOy);
      paramInt = i;
      if (this.wKl != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.wKl);
      }
      i = paramInt;
      if (this.wKp != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.wKp);
      }
      i += e.a.a.b.b.a.bl(6, this.iFL);
      paramInt = i;
      if (this.oiG != null) {
        paramInt = i + e.a.a.b.b.a.f(7, this.oiG);
      }
      AppMethodBeat.o(48828);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(48828);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        vv localvv = (vv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(48828);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new hq();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((hq)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localvv.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(48828);
          return 0;
        case 2: 
          localvv.wOx = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(48828);
          return 0;
        case 3: 
          localvv.wOy = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(48828);
          return 0;
        case 4: 
          localvv.wKl = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(48828);
          return 0;
        case 5: 
          localvv.wKp = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(48828);
          return 0;
        case 6: 
          localvv.iFL = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(48828);
          return 0;
        }
        localvv.oiG = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(48828);
        return 0;
      }
      AppMethodBeat.o(48828);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.vv
 * JD-Core Version:    0.7.0.1
 */