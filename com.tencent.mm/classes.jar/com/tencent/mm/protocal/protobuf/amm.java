package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class amm
  extends dyl
{
  public String SwL;
  public String SwM;
  public long SwN;
  public double SwO;
  public double SwP;
  public String city;
  public String province;
  public String vhY;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91452);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.vhY != null) {
        paramVarArgs.f(2, this.vhY);
      }
      if (this.city != null) {
        paramVarArgs.f(3, this.city);
      }
      if (this.province != null) {
        paramVarArgs.f(4, this.province);
      }
      if (this.SwL != null) {
        paramVarArgs.f(5, this.SwL);
      }
      if (this.SwM != null) {
        paramVarArgs.f(6, this.SwM);
      }
      paramVarArgs.bm(7, this.SwN);
      paramVarArgs.e(8, this.SwO);
      paramVarArgs.e(9, this.SwP);
      AppMethodBeat.o(91452);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label738;
      }
    }
    label738:
    for (int i = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.vhY != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.vhY);
      }
      i = paramInt;
      if (this.city != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.city);
      }
      paramInt = i;
      if (this.province != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.province);
      }
      i = paramInt;
      if (this.SwL != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.SwL);
      }
      paramInt = i;
      if (this.SwM != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.SwM);
      }
      i = g.a.a.b.b.a.p(7, this.SwN);
      int j = g.a.a.b.b.a.gL(8);
      int k = g.a.a.b.b.a.gL(9);
      AppMethodBeat.o(91452);
      return paramInt + i + (j + 8) + (k + 8);
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(91452);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        amm localamm = (amm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91452);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            jg localjg = new jg();
            if ((localObject != null) && (localObject.length > 0)) {
              localjg.parseFrom((byte[])localObject);
            }
            localamm.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(91452);
          return 0;
        case 2: 
          localamm.vhY = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(91452);
          return 0;
        case 3: 
          localamm.city = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(91452);
          return 0;
        case 4: 
          localamm.province = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(91452);
          return 0;
        case 5: 
          localamm.SwL = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(91452);
          return 0;
        case 6: 
          localamm.SwM = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(91452);
          return 0;
        case 7: 
          localamm.SwN = ((g.a.a.a.a)localObject).abFh.AN();
          AppMethodBeat.o(91452);
          return 0;
        case 8: 
          localamm.SwO = Double.longBitsToDouble(((g.a.a.a.a)localObject).abFh.AP());
          AppMethodBeat.o(91452);
          return 0;
        }
        localamm.SwP = Double.longBitsToDouble(((g.a.a.a.a)localObject).abFh.AP());
        AppMethodBeat.o(91452);
        return 0;
      }
      AppMethodBeat.o(91452);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.amm
 * JD-Core Version:    0.7.0.1
 */