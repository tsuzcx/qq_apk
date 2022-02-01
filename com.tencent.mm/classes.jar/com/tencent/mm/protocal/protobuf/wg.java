package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class wg
  extends cvc
{
  public String FAa;
  public String FOH;
  public String FVF;
  public String FVG;
  public int Fyv;
  public long FzZ;
  public String uki;
  public String ukj;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(9586);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.ukj != null) {
        paramVarArgs.d(2, this.ukj);
      }
      if (this.uki != null) {
        paramVarArgs.d(3, this.uki);
      }
      paramVarArgs.aY(4, this.FzZ);
      if (this.FOH != null) {
        paramVarArgs.d(5, this.FOH);
      }
      if (this.FVF != null) {
        paramVarArgs.d(6, this.FVF);
      }
      paramVarArgs.aS(7, this.Fyv);
      if (this.FAa != null) {
        paramVarArgs.d(8, this.FAa);
      }
      if (this.FVG != null) {
        paramVarArgs.d(9, this.FVG);
      }
      AppMethodBeat.o(9586);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label781;
      }
    }
    label781:
    for (int i = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ukj != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.ukj);
      }
      i = paramInt;
      if (this.uki != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.uki);
      }
      i += f.a.a.b.b.a.p(4, this.FzZ);
      paramInt = i;
      if (this.FOH != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.FOH);
      }
      i = paramInt;
      if (this.FVF != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.FVF);
      }
      i += f.a.a.b.b.a.bz(7, this.Fyv);
      paramInt = i;
      if (this.FAa != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.FAa);
      }
      i = paramInt;
      if (this.FVG != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.FVG);
      }
      AppMethodBeat.o(9586);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(9586);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        wg localwg = (wg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(9586);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localwg.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(9586);
          return 0;
        case 2: 
          localwg.ukj = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(9586);
          return 0;
        case 3: 
          localwg.uki = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(9586);
          return 0;
        case 4: 
          localwg.FzZ = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(9586);
          return 0;
        case 5: 
          localwg.FOH = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(9586);
          return 0;
        case 6: 
          localwg.FVF = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(9586);
          return 0;
        case 7: 
          localwg.Fyv = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(9586);
          return 0;
        case 8: 
          localwg.FAa = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(9586);
          return 0;
        }
        localwg.FVG = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(9586);
        return 0;
      }
      AppMethodBeat.o(9586);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.wg
 * JD-Core Version:    0.7.0.1
 */