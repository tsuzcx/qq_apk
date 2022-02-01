package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class adw
  extends com.tencent.mm.cd.a
{
  public String CMB;
  public bjf SqA;
  public int Sqq;
  public LinkedList<cvt> Sqr;
  public int Sqs;
  public String Sqt;
  public cuf Squ;
  public bjg Sqv;
  public jd Sqw;
  public bja Sqx;
  public cwx Sqy;
  public bjg Sqz;
  public String Url;
  public bje fFJ;
  public String fwr;
  public dbr lVY;
  public int loX;
  public bcp yNL;
  
  public adw()
  {
    AppMethodBeat.i(125718);
    this.Sqr = new LinkedList();
    AppMethodBeat.o(125718);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125719);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.CMB != null) {
        paramVarArgs.f(1, this.CMB);
      }
      paramVarArgs.aY(2, this.Sqq);
      if (this.fwr != null) {
        paramVarArgs.f(3, this.fwr);
      }
      if (this.Url != null) {
        paramVarArgs.f(4, this.Url);
      }
      paramVarArgs.e(5, 8, this.Sqr);
      paramVarArgs.aY(6, this.Sqs);
      if (this.Sqt != null) {
        paramVarArgs.f(7, this.Sqt);
      }
      if (this.Squ != null)
      {
        paramVarArgs.oE(8, this.Squ.computeSize());
        this.Squ.writeFields(paramVarArgs);
      }
      if (this.fFJ != null)
      {
        paramVarArgs.oE(9, this.fFJ.computeSize());
        this.fFJ.writeFields(paramVarArgs);
      }
      if (this.Sqv != null)
      {
        paramVarArgs.oE(10, this.Sqv.computeSize());
        this.Sqv.writeFields(paramVarArgs);
      }
      if (this.Sqw != null)
      {
        paramVarArgs.oE(11, this.Sqw.computeSize());
        this.Sqw.writeFields(paramVarArgs);
      }
      if (this.Sqx != null)
      {
        paramVarArgs.oE(12, this.Sqx.computeSize());
        this.Sqx.writeFields(paramVarArgs);
      }
      if (this.yNL != null)
      {
        paramVarArgs.oE(13, this.yNL.computeSize());
        this.yNL.writeFields(paramVarArgs);
      }
      if (this.Sqy != null)
      {
        paramVarArgs.oE(14, this.Sqy.computeSize());
        this.Sqy.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(15, this.loX);
      if (this.Sqz != null)
      {
        paramVarArgs.oE(16, this.Sqz.computeSize());
        this.Sqz.writeFields(paramVarArgs);
      }
      if (this.lVY != null)
      {
        paramVarArgs.oE(17, this.lVY.computeSize());
        this.lVY.writeFields(paramVarArgs);
      }
      if (this.SqA != null)
      {
        paramVarArgs.oE(18, this.SqA.computeSize());
        this.SqA.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(125719);
      return 0;
    }
    if (paramInt == 1) {
      if (this.CMB == null) {
        break label1992;
      }
    }
    label1992:
    for (paramInt = g.a.a.b.b.a.g(1, this.CMB) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.Sqq);
      paramInt = i;
      if (this.fwr != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.fwr);
      }
      i = paramInt;
      if (this.Url != null) {
        i = paramInt + g.a.a.b.b.a.g(4, this.Url);
      }
      i = i + g.a.a.a.c(5, 8, this.Sqr) + g.a.a.b.b.a.bM(6, this.Sqs);
      paramInt = i;
      if (this.Sqt != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.Sqt);
      }
      i = paramInt;
      if (this.Squ != null) {
        i = paramInt + g.a.a.a.oD(8, this.Squ.computeSize());
      }
      paramInt = i;
      if (this.fFJ != null) {
        paramInt = i + g.a.a.a.oD(9, this.fFJ.computeSize());
      }
      i = paramInt;
      if (this.Sqv != null) {
        i = paramInt + g.a.a.a.oD(10, this.Sqv.computeSize());
      }
      paramInt = i;
      if (this.Sqw != null) {
        paramInt = i + g.a.a.a.oD(11, this.Sqw.computeSize());
      }
      i = paramInt;
      if (this.Sqx != null) {
        i = paramInt + g.a.a.a.oD(12, this.Sqx.computeSize());
      }
      paramInt = i;
      if (this.yNL != null) {
        paramInt = i + g.a.a.a.oD(13, this.yNL.computeSize());
      }
      i = paramInt;
      if (this.Sqy != null) {
        i = paramInt + g.a.a.a.oD(14, this.Sqy.computeSize());
      }
      i += g.a.a.b.b.a.bM(15, this.loX);
      paramInt = i;
      if (this.Sqz != null) {
        paramInt = i + g.a.a.a.oD(16, this.Sqz.computeSize());
      }
      i = paramInt;
      if (this.lVY != null) {
        i = paramInt + g.a.a.a.oD(17, this.lVY.computeSize());
      }
      paramInt = i;
      if (this.SqA != null) {
        paramInt = i + g.a.a.a.oD(18, this.SqA.computeSize());
      }
      AppMethodBeat.o(125719);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Sqr.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(125719);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        adw localadw = (adw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125719);
          return -1;
        case 1: 
          localadw.CMB = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(125719);
          return 0;
        case 2: 
          localadw.Sqq = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(125719);
          return 0;
        case 3: 
          localadw.fwr = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(125719);
          return 0;
        case 4: 
          localadw.Url = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(125719);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new cvt();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((cvt)localObject2).parseFrom((byte[])localObject1);
            }
            localadw.Sqr.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125719);
          return 0;
        case 6: 
          localadw.Sqs = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(125719);
          return 0;
        case 7: 
          localadw.Sqt = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(125719);
          return 0;
        case 8: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new cuf();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((cuf)localObject2).parseFrom((byte[])localObject1);
            }
            localadw.Squ = ((cuf)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125719);
          return 0;
        case 9: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bje();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bje)localObject2).parseFrom((byte[])localObject1);
            }
            localadw.fFJ = ((bje)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125719);
          return 0;
        case 10: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bjg();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bjg)localObject2).parseFrom((byte[])localObject1);
            }
            localadw.Sqv = ((bjg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125719);
          return 0;
        case 11: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jd();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jd)localObject2).parseFrom((byte[])localObject1);
            }
            localadw.Sqw = ((jd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125719);
          return 0;
        case 12: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bja();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bja)localObject2).parseFrom((byte[])localObject1);
            }
            localadw.Sqx = ((bja)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125719);
          return 0;
        case 13: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bcp();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bcp)localObject2).parseFrom((byte[])localObject1);
            }
            localadw.yNL = ((bcp)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125719);
          return 0;
        case 14: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new cwx();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((cwx)localObject2).parseFrom((byte[])localObject1);
            }
            localadw.Sqy = ((cwx)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125719);
          return 0;
        case 15: 
          localadw.loX = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(125719);
          return 0;
        case 16: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bjg();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bjg)localObject2).parseFrom((byte[])localObject1);
            }
            localadw.Sqz = ((bjg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125719);
          return 0;
        case 17: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dbr();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dbr)localObject2).parseFrom((byte[])localObject1);
            }
            localadw.lVY = ((dbr)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125719);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new bjf();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((bjf)localObject2).parseFrom((byte[])localObject1);
          }
          localadw.SqA = ((bjf)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(125719);
        return 0;
      }
      AppMethodBeat.o(125719);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.adw
 * JD-Core Version:    0.7.0.1
 */