package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class io
  extends com.tencent.mm.bx.a
{
  public String CEf;
  public String CEg;
  public String dEy;
  public String dEz;
  public String dfT;
  public String gKD;
  public String gKv;
  public String gKw;
  public int height;
  public String title;
  public String url;
  public int videoDuration;
  public String videoUrl;
  public int width;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(43083);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.CEf != null) {
        paramVarArgs.d(1, this.CEf);
      }
      if (this.videoUrl != null) {
        paramVarArgs.d(2, this.videoUrl);
      }
      if (this.CEg != null) {
        paramVarArgs.d(3, this.CEg);
      }
      if (this.title != null) {
        paramVarArgs.d(4, this.title);
      }
      if (this.gKD != null) {
        paramVarArgs.d(5, this.gKD);
      }
      paramVarArgs.aR(6, this.videoDuration);
      paramVarArgs.aR(7, this.width);
      paramVarArgs.aR(8, this.height);
      if (this.url != null) {
        paramVarArgs.d(9, this.url);
      }
      if (this.dfT != null) {
        paramVarArgs.d(10, this.dfT);
      }
      if (this.gKv != null) {
        paramVarArgs.d(11, this.gKv);
      }
      if (this.gKw != null) {
        paramVarArgs.d(12, this.gKw);
      }
      if (this.dEz != null) {
        paramVarArgs.d(13, this.dEz);
      }
      if (this.dEy != null) {
        paramVarArgs.d(14, this.dEy);
      }
      AppMethodBeat.o(43083);
      return 0;
    }
    if (paramInt == 1) {
      if (this.CEf == null) {
        break label962;
      }
    }
    label962:
    for (int i = f.a.a.b.b.a.e(1, this.CEf) + 0;; i = 0)
    {
      paramInt = i;
      if (this.videoUrl != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.videoUrl);
      }
      i = paramInt;
      if (this.CEg != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.CEg);
      }
      paramInt = i;
      if (this.title != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.title);
      }
      i = paramInt;
      if (this.gKD != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.gKD);
      }
      i = i + f.a.a.b.b.a.bA(6, this.videoDuration) + f.a.a.b.b.a.bA(7, this.width) + f.a.a.b.b.a.bA(8, this.height);
      paramInt = i;
      if (this.url != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.url);
      }
      i = paramInt;
      if (this.dfT != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.dfT);
      }
      paramInt = i;
      if (this.gKv != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.gKv);
      }
      i = paramInt;
      if (this.gKw != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.gKw);
      }
      paramInt = i;
      if (this.dEz != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.dEz);
      }
      i = paramInt;
      if (this.dEy != null) {
        i = paramInt + f.a.a.b.b.a.e(14, this.dEy);
      }
      AppMethodBeat.o(43083);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(43083);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        io localio = (io)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(43083);
          return -1;
        case 1: 
          localio.CEf = locala.KhF.readString();
          AppMethodBeat.o(43083);
          return 0;
        case 2: 
          localio.videoUrl = locala.KhF.readString();
          AppMethodBeat.o(43083);
          return 0;
        case 3: 
          localio.CEg = locala.KhF.readString();
          AppMethodBeat.o(43083);
          return 0;
        case 4: 
          localio.title = locala.KhF.readString();
          AppMethodBeat.o(43083);
          return 0;
        case 5: 
          localio.gKD = locala.KhF.readString();
          AppMethodBeat.o(43083);
          return 0;
        case 6: 
          localio.videoDuration = locala.KhF.xS();
          AppMethodBeat.o(43083);
          return 0;
        case 7: 
          localio.width = locala.KhF.xS();
          AppMethodBeat.o(43083);
          return 0;
        case 8: 
          localio.height = locala.KhF.xS();
          AppMethodBeat.o(43083);
          return 0;
        case 9: 
          localio.url = locala.KhF.readString();
          AppMethodBeat.o(43083);
          return 0;
        case 10: 
          localio.dfT = locala.KhF.readString();
          AppMethodBeat.o(43083);
          return 0;
        case 11: 
          localio.gKv = locala.KhF.readString();
          AppMethodBeat.o(43083);
          return 0;
        case 12: 
          localio.gKw = locala.KhF.readString();
          AppMethodBeat.o(43083);
          return 0;
        case 13: 
          localio.dEz = locala.KhF.readString();
          AppMethodBeat.o(43083);
          return 0;
        }
        localio.dEy = locala.KhF.readString();
        AppMethodBeat.o(43083);
        return 0;
      }
      AppMethodBeat.o(43083);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.io
 * JD-Core Version:    0.7.0.1
 */