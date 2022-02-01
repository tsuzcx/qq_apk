package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class anb
  extends dyl
{
  public String RSB;
  public long Sxk;
  public String Sxl;
  public String Sxm;
  public int Sxn;
  public float Sxo;
  public int Sxp;
  public String appid;
  public int source;
  public int wvP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104363);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.appid != null) {
        paramVarArgs.f(2, this.appid);
      }
      paramVarArgs.bm(3, this.Sxk);
      if (this.RSB != null) {
        paramVarArgs.f(4, this.RSB);
      }
      if (this.Sxl != null) {
        paramVarArgs.f(5, this.Sxl);
      }
      if (this.Sxm != null) {
        paramVarArgs.f(6, this.Sxm);
      }
      paramVarArgs.aY(7, this.source);
      paramVarArgs.aY(8, this.Sxn);
      paramVarArgs.aY(9, this.wvP);
      paramVarArgs.i(10, this.Sxo);
      paramVarArgs.aY(11, this.Sxp);
      AppMethodBeat.o(104363);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label815;
      }
    }
    label815:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.appid != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.appid);
      }
      i += g.a.a.b.b.a.p(3, this.Sxk);
      paramInt = i;
      if (this.RSB != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.RSB);
      }
      i = paramInt;
      if (this.Sxl != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.Sxl);
      }
      paramInt = i;
      if (this.Sxm != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.Sxm);
      }
      i = g.a.a.b.b.a.bM(7, this.source);
      int j = g.a.a.b.b.a.bM(8, this.Sxn);
      int k = g.a.a.b.b.a.bM(9, this.wvP);
      int m = g.a.a.b.b.a.gL(10);
      int n = g.a.a.b.b.a.bM(11, this.Sxp);
      AppMethodBeat.o(104363);
      return paramInt + i + j + k + (m + 4) + n;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(104363);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        anb localanb = (anb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(104363);
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
            localanb.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(104363);
          return 0;
        case 2: 
          localanb.appid = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(104363);
          return 0;
        case 3: 
          localanb.Sxk = ((g.a.a.a.a)localObject).abFh.AN();
          AppMethodBeat.o(104363);
          return 0;
        case 4: 
          localanb.RSB = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(104363);
          return 0;
        case 5: 
          localanb.Sxl = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(104363);
          return 0;
        case 6: 
          localanb.Sxm = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(104363);
          return 0;
        case 7: 
          localanb.source = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(104363);
          return 0;
        case 8: 
          localanb.Sxn = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(104363);
          return 0;
        case 9: 
          localanb.wvP = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(104363);
          return 0;
        case 10: 
          localanb.Sxo = Float.intBitsToFloat(((g.a.a.a.a)localObject).abFh.AO());
          AppMethodBeat.o(104363);
          return 0;
        }
        localanb.Sxp = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(104363);
        return 0;
      }
      AppMethodBeat.o(104363);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.anb
 * JD-Core Version:    0.7.0.1
 */