package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eoi
  extends com.tencent.mm.cd.a
{
  public String CRQ;
  public String CRR;
  public int CreateTime;
  public long Id;
  public int IsNotRichText;
  public String ThumbUrl;
  public int Ulm;
  public int Uln;
  public String UpX;
  public String UpY;
  public int Uqa;
  public eob Uqi;
  public String lpy;
  public int rWu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118472);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bm(1, this.Id);
      if (this.CRR != null) {
        paramVarArgs.f(2, this.CRR);
      }
      if (this.CRQ != null) {
        paramVarArgs.f(3, this.CRQ);
      }
      if (this.UpX != null) {
        paramVarArgs.f(4, this.UpX);
      }
      if (this.UpY != null) {
        paramVarArgs.f(5, this.UpY);
      }
      if (this.lpy != null) {
        paramVarArgs.f(6, this.lpy);
      }
      paramVarArgs.aY(7, this.rWu);
      paramVarArgs.aY(8, this.CreateTime);
      paramVarArgs.aY(9, this.Uln);
      paramVarArgs.aY(10, this.Ulm);
      paramVarArgs.aY(11, this.IsNotRichText);
      if (this.ThumbUrl != null) {
        paramVarArgs.f(12, this.ThumbUrl);
      }
      if (this.Uqi != null)
      {
        paramVarArgs.oE(13, this.Uqi.computeSize());
        this.Uqi.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(14, this.Uqa);
      AppMethodBeat.o(118472);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.p(1, this.Id) + 0;
      paramInt = i;
      if (this.CRR != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.CRR);
      }
      i = paramInt;
      if (this.CRQ != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.CRQ);
      }
      paramInt = i;
      if (this.UpX != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.UpX);
      }
      i = paramInt;
      if (this.UpY != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.UpY);
      }
      paramInt = i;
      if (this.lpy != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.lpy);
      }
      i = paramInt + g.a.a.b.b.a.bM(7, this.rWu) + g.a.a.b.b.a.bM(8, this.CreateTime) + g.a.a.b.b.a.bM(9, this.Uln) + g.a.a.b.b.a.bM(10, this.Ulm) + g.a.a.b.b.a.bM(11, this.IsNotRichText);
      paramInt = i;
      if (this.ThumbUrl != null) {
        paramInt = i + g.a.a.b.b.a.g(12, this.ThumbUrl);
      }
      i = paramInt;
      if (this.Uqi != null) {
        i = paramInt + g.a.a.a.oD(13, this.Uqi.computeSize());
      }
      paramInt = g.a.a.b.b.a.bM(14, this.Uqa);
      AppMethodBeat.o(118472);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(118472);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      eoi localeoi = (eoi)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(118472);
        return -1;
      case 1: 
        localeoi.Id = ((g.a.a.a.a)localObject).abFh.AN();
        AppMethodBeat.o(118472);
        return 0;
      case 2: 
        localeoi.CRR = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(118472);
        return 0;
      case 3: 
        localeoi.CRQ = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(118472);
        return 0;
      case 4: 
        localeoi.UpX = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(118472);
        return 0;
      case 5: 
        localeoi.UpY = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(118472);
        return 0;
      case 6: 
        localeoi.lpy = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(118472);
        return 0;
      case 7: 
        localeoi.rWu = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(118472);
        return 0;
      case 8: 
        localeoi.CreateTime = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(118472);
        return 0;
      case 9: 
        localeoi.Uln = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(118472);
        return 0;
      case 10: 
        localeoi.Ulm = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(118472);
        return 0;
      case 11: 
        localeoi.IsNotRichText = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(118472);
        return 0;
      case 12: 
        localeoi.ThumbUrl = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(118472);
        return 0;
      case 13: 
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          eob localeob = new eob();
          if ((localObject != null) && (localObject.length > 0)) {
            localeob.parseFrom((byte[])localObject);
          }
          localeoi.Uqi = localeob;
          paramInt += 1;
        }
        AppMethodBeat.o(118472);
        return 0;
      }
      localeoi.Uqa = ((g.a.a.a.a)localObject).abFh.AK();
      AppMethodBeat.o(118472);
      return 0;
    }
    AppMethodBeat.o(118472);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eoi
 * JD-Core Version:    0.7.0.1
 */