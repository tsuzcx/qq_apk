package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cha
  extends ckq
{
  public String Abv;
  public String Ahs;
  public String dlJ;
  public String zWw;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(174534);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.dlJ != null) {
        paramVarArgs.d(2, this.dlJ);
      }
      if (this.zWw != null) {
        paramVarArgs.d(3, this.zWw);
      }
      if (this.Abv != null) {
        paramVarArgs.d(4, this.Abv);
      }
      if (this.Ahs != null) {
        paramVarArgs.d(5, this.Ahs);
      }
      AppMethodBeat.o(174534);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label550;
      }
    }
    label550:
    for (int i = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.dlJ != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.dlJ);
      }
      i = paramInt;
      if (this.zWw != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.zWw);
      }
      paramInt = i;
      if (this.Abv != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Abv);
      }
      i = paramInt;
      if (this.Ahs != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.Ahs);
      }
      AppMethodBeat.o(174534);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(174534);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cha localcha = (cha)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(174534);
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
            localcha.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(174534);
          return 0;
        case 2: 
          localcha.dlJ = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(174534);
          return 0;
        case 3: 
          localcha.zWw = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(174534);
          return 0;
        case 4: 
          localcha.Abv = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(174534);
          return 0;
        }
        localcha.Ahs = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(174534);
        return 0;
      }
      AppMethodBeat.o(174534);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cha
 * JD-Core Version:    0.7.0.1
 */