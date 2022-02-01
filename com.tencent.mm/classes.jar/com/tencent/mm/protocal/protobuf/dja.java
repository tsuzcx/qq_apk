package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dja
  extends dyl
{
  public String CQz;
  public String CqB;
  public String SYW;
  public bd Sdp;
  public String SlA;
  public String SlB;
  public String Sly;
  public String Slz;
  public String TQA;
  public String TQB;
  public String TQC;
  public String TQy;
  public String TQz;
  public String lVG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91571);
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
      if (this.TQy != null) {
        paramVarArgs.f(3, this.TQy);
      }
      if (this.SYW != null) {
        paramVarArgs.f(4, this.SYW);
      }
      if (this.Sly != null) {
        paramVarArgs.f(5, this.Sly);
      }
      if (this.TQz != null) {
        paramVarArgs.f(6, this.TQz);
      }
      if (this.Slz != null) {
        paramVarArgs.f(7, this.Slz);
      }
      if (this.SlA != null) {
        paramVarArgs.f(8, this.SlA);
      }
      if (this.SlB != null) {
        paramVarArgs.f(9, this.SlB);
      }
      if (this.TQA != null) {
        paramVarArgs.f(10, this.TQA);
      }
      if (this.Sdp != null)
      {
        paramVarArgs.oE(11, this.Sdp.computeSize());
        this.Sdp.writeFields(paramVarArgs);
      }
      if (this.TQB != null) {
        paramVarArgs.f(12, this.TQB);
      }
      if (this.CqB != null) {
        paramVarArgs.f(13, this.CqB);
      }
      if (this.CQz != null) {
        paramVarArgs.f(14, this.CQz);
      }
      if (this.TQC != null) {
        paramVarArgs.f(15, this.TQC);
      }
      AppMethodBeat.o(91571);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1222;
      }
    }
    label1222:
    for (int i = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.lVG != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.lVG);
      }
      i = paramInt;
      if (this.TQy != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.TQy);
      }
      paramInt = i;
      if (this.SYW != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.SYW);
      }
      i = paramInt;
      if (this.Sly != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.Sly);
      }
      paramInt = i;
      if (this.TQz != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.TQz);
      }
      i = paramInt;
      if (this.Slz != null) {
        i = paramInt + g.a.a.b.b.a.g(7, this.Slz);
      }
      paramInt = i;
      if (this.SlA != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.SlA);
      }
      i = paramInt;
      if (this.SlB != null) {
        i = paramInt + g.a.a.b.b.a.g(9, this.SlB);
      }
      paramInt = i;
      if (this.TQA != null) {
        paramInt = i + g.a.a.b.b.a.g(10, this.TQA);
      }
      i = paramInt;
      if (this.Sdp != null) {
        i = paramInt + g.a.a.a.oD(11, this.Sdp.computeSize());
      }
      paramInt = i;
      if (this.TQB != null) {
        paramInt = i + g.a.a.b.b.a.g(12, this.TQB);
      }
      i = paramInt;
      if (this.CqB != null) {
        i = paramInt + g.a.a.b.b.a.g(13, this.CqB);
      }
      paramInt = i;
      if (this.CQz != null) {
        paramInt = i + g.a.a.b.b.a.g(14, this.CQz);
      }
      i = paramInt;
      if (this.TQC != null) {
        i = paramInt + g.a.a.b.b.a.g(15, this.TQC);
      }
      AppMethodBeat.o(91571);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(91571);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dja localdja = (dja)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91571);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jg();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jg)localObject2).parseFrom((byte[])localObject1);
            }
            localdja.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91571);
          return 0;
        case 2: 
          localdja.lVG = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91571);
          return 0;
        case 3: 
          localdja.TQy = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91571);
          return 0;
        case 4: 
          localdja.SYW = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91571);
          return 0;
        case 5: 
          localdja.Sly = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91571);
          return 0;
        case 6: 
          localdja.TQz = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91571);
          return 0;
        case 7: 
          localdja.Slz = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91571);
          return 0;
        case 8: 
          localdja.SlA = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91571);
          return 0;
        case 9: 
          localdja.SlB = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91571);
          return 0;
        case 10: 
          localdja.TQA = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91571);
          return 0;
        case 11: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bd();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bd)localObject2).parseFrom((byte[])localObject1);
            }
            localdja.Sdp = ((bd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91571);
          return 0;
        case 12: 
          localdja.TQB = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91571);
          return 0;
        case 13: 
          localdja.CqB = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91571);
          return 0;
        case 14: 
          localdja.CQz = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91571);
          return 0;
        }
        localdja.TQC = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(91571);
        return 0;
      }
      AppMethodBeat.o(91571);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dja
 * JD-Core Version:    0.7.0.1
 */