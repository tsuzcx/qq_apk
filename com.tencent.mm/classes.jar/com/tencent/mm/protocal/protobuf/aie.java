package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aie
  extends dyl
{
  public long HlH;
  public int HmZ;
  public int Hna;
  public int Hnb;
  public int RJP;
  public String SsW;
  public int SsX;
  public int SsY;
  public String UserName;
  public String lVG;
  public String lVJ;
  public int rWu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(9590);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.lVG != null) {
        paramVarArgs.f(2, this.lVG);
      }
      paramVarArgs.aY(3, this.RJP);
      if (this.lVJ != null) {
        paramVarArgs.f(4, this.lVJ);
      }
      if (this.UserName != null) {
        paramVarArgs.f(5, this.UserName);
      }
      paramVarArgs.aY(6, this.HmZ);
      paramVarArgs.aY(7, this.Hna);
      paramVarArgs.aY(8, this.Hnb);
      if (this.SsW != null) {
        paramVarArgs.f(9, this.SsW);
      }
      paramVarArgs.aY(10, this.SsX);
      paramVarArgs.aY(11, this.rWu);
      paramVarArgs.aY(12, this.SsY);
      paramVarArgs.bm(13, this.HlH);
      AppMethodBeat.o(9590);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label919;
      }
    }
    label919:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.lVG != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.lVG);
      }
      i += g.a.a.b.b.a.bM(3, this.RJP);
      paramInt = i;
      if (this.lVJ != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.lVJ);
      }
      i = paramInt;
      if (this.UserName != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.UserName);
      }
      i = i + g.a.a.b.b.a.bM(6, this.HmZ) + g.a.a.b.b.a.bM(7, this.Hna) + g.a.a.b.b.a.bM(8, this.Hnb);
      paramInt = i;
      if (this.SsW != null) {
        paramInt = i + g.a.a.b.b.a.g(9, this.SsW);
      }
      i = g.a.a.b.b.a.bM(10, this.SsX);
      int j = g.a.a.b.b.a.bM(11, this.rWu);
      int k = g.a.a.b.b.a.bM(12, this.SsY);
      int m = g.a.a.b.b.a.p(13, this.HlH);
      AppMethodBeat.o(9590);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(9590);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        aie localaie = (aie)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(9590);
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
            localaie.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(9590);
          return 0;
        case 2: 
          localaie.lVG = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(9590);
          return 0;
        case 3: 
          localaie.RJP = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(9590);
          return 0;
        case 4: 
          localaie.lVJ = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(9590);
          return 0;
        case 5: 
          localaie.UserName = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(9590);
          return 0;
        case 6: 
          localaie.HmZ = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(9590);
          return 0;
        case 7: 
          localaie.Hna = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(9590);
          return 0;
        case 8: 
          localaie.Hnb = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(9590);
          return 0;
        case 9: 
          localaie.SsW = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(9590);
          return 0;
        case 10: 
          localaie.SsX = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(9590);
          return 0;
        case 11: 
          localaie.rWu = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(9590);
          return 0;
        case 12: 
          localaie.SsY = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(9590);
          return 0;
        }
        localaie.HlH = ((g.a.a.a.a)localObject).abFh.AN();
        AppMethodBeat.o(9590);
        return 0;
      }
      AppMethodBeat.o(9590);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aie
 * JD-Core Version:    0.7.0.1
 */